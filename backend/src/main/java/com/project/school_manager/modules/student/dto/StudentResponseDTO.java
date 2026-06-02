package com.project.school_manager.modules.student.dto;

public record StudentResponseDTO(
        String id,
        String name,
        String guardianName,
        String guardianCpf,
        String phone,
        String address
) {}