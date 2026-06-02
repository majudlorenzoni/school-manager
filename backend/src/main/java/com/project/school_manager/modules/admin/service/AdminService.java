package com.project.school_manager.modules.admin.service;

import com.project.school_manager.modules.user.User;
import com.project.school_manager.modules.user.dto.UserResponseDTO;
import com.project.school_manager.modules.user.entity.UserRole;
import com.project.school_manager.modules.user.repository.UserRepository;
import com.project.school_manager.modules.user.repository.UserUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        return userRepository.findByRole(UserRole.ADMIN)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public UserResponseDTO findById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Admin não encontrado: " + id));

        if (user.getRole() != UserRole.ADMIN) {
            throw new EntityNotFoundException("Admin não encontrado: " + id);
        }

        return toResponse(user);
    }

    public List<UserResponseDTO> findByName(String name) {
        return userRepository
                .findByRoleAndNameContainingIgnoreCase(
                        UserRole.ADMIN,
                        name
                )
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public UserResponseDTO update(String id, UserUpdateDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Admin não encontrado: " + id));

        if (user.getRole() != UserRole.ADMIN) {
            throw new EntityNotFoundException("Admin não encontrado: " + id);
        }

        user.setName(dto.name());
        user.setLogin(dto.login());
        user.setCpf(dto.cpf());

        userRepository.save(user);

        return toResponse(user);
    }

    public void delete(String id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Admin não encontrado: " + id));

        if (user.getRole() != UserRole.ADMIN) {
            throw new EntityNotFoundException("Admin não encontrado: " + id);
        }

        userRepository.delete(user);
    }

    private UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getCpf(),
                user.getRole()
        );
    }
}