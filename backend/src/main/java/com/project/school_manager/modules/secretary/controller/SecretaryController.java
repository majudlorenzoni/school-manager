package com.project.school_manager.modules.secretary.controller;

import com.project.school_manager.modules.secretary.service.SecretaryService;
import com.project.school_manager.modules.user.User;
import com.project.school_manager.modules.user.dto.UserResponseDTO;
import com.project.school_manager.modules.user.entity.UserRole;
import com.project.school_manager.modules.user.repository.UserRepository;
import com.project.school_manager.modules.user.repository.UserUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretaries")
public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SECRETARY', 'TEACHER')")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(secretaryService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SECRETARY', 'TEACHER')")
    public ResponseEntity<UserResponseDTO> findById(
            @PathVariable String id) {

        return ResponseEntity.ok(secretaryService.findById(id));
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN', 'SECRETARY', 'TEACHER')")
    public ResponseEntity<List<UserResponseDTO>> findByName(
            @RequestParam String name) {

        return ResponseEntity.ok(secretaryService.findByName(name));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponseDTO> update(
            @PathVariable String id,
            @RequestBody @Valid UserUpdateDTO dto) {

        return ResponseEntity.ok(secretaryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(
            @PathVariable String id) {

        secretaryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}