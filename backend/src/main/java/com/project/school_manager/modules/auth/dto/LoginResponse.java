package com.project.school_manager.modules.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LoginResponse {

    private String token;
    private String type;
    private Long userId;
    private String email;
    private String fullname;
    private String role;

    public LoginResponse (String token, Long userId, String email, String fullName, String role) {
        this.token = token;
        this.type = "Bearer";
        this.userId = userId;
        this.email = email;
        this.fullname = fullName;
        this.role = role;
    }
}
