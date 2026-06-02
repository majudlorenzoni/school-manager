package com.project.school_manager.modules.student.dto;

public record StudentUpdateDTO(
        String name,
        String guardianName,
        String guardianCpf,
        String phone,
        String address
) {}