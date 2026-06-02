package com.project.school_manager.modules.user.dto;

import com.project.school_manager.modules.user.entity.UserRole;

public record UserResponseDTO(
        String id,
        String name,
        String login,
        String cpf,
        UserRole role
) {
}