package com.project.school_manager.modules.user.repository;

import com.project.school_manager.modules.user.User;
import com.project.school_manager.modules.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, String>{

    UserDetails findByLogin(String login);

    List<User> findByRole(UserRole role);

    List<User> findByRoleAndNameContainingIgnoreCase(
            UserRole role,
            String name
    );}
