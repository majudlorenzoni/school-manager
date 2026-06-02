package com.project.school_manager.modules.teacher.controller;

import com.project.school_manager.modules.teacher.service.TeacherService;
import com.project.school_manager.modules.user.dto.UserResponseDTO;
import com.project.school_manager.modules.user.repository.UserUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN, 'SECRETARY')")
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN, 'SECRETARY')")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable String id){
        return ResponseEntity.ok(teacherService.findById(id));
    }


    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN, 'SECRETARY')")
    public ResponseEntity<List<UserResponseDTO>> findByName(@PathVariable String name){
        return ResponseEntity.ok(teacherService.findByName(name));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponseDTO> update(
            @PathVariable String id,
            @RequestBody @Valid UserUpdateDTO dto) {

        return ResponseEntity.ok(teacherService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(
            @PathVariable String id) {

        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
