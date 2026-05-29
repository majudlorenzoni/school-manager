package com.project.school_manager.modules.auth.dto;

import com.project.school_manager.modules.user.entity.UserRole;

public record RegisterDTO(String login, String password, UserRole role, String name, String cpf) {
}
