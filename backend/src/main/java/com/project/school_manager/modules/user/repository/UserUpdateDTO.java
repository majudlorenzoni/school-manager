package com.project.school_manager.modules.user.repository;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateDTO(
        @NotBlank String name,
        @NotBlank String login,
        @NotBlank String cpf
) {
}