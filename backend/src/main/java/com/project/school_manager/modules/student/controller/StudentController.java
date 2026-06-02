package com.project.school_manager.modules.student.controller;

import com.project.school_manager.modules.student.dto.StudentCreateDTO;
import com.project.school_manager.modules.student.dto.StudentResponseDTO;
import com.project.school_manager.modules.student.dto.StudentUpdateDTO;
import com.project.school_manager.modules.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SECRETARY', 'TEACHER')")
    public ResponseEntity<List<StudentResponseDTO>> findAll() {

        return ResponseEntity.ok(
                studentService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SECRETARY', 'TEACHER')")
    public ResponseEntity<StudentResponseDTO> findById(
            @PathVariable String id) {

        return ResponseEntity.ok(
                studentService.findById(id));
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN', 'SECRETARY', 'TEACHER')")
    public ResponseEntity<List<StudentResponseDTO>> findByName(
            @RequestParam String name) {

        return ResponseEntity.ok(
                studentService.findByName(name));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SECRETARY')")
    public ResponseEntity<StudentResponseDTO> create(
            @RequestBody @Valid StudentCreateDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SECRETARY')")
    public ResponseEntity<StudentResponseDTO> update(
            @PathVariable String id,
            @RequestBody @Valid StudentUpdateDTO dto) {

        return ResponseEntity.ok(
                studentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SECRETARY')")
    public ResponseEntity<Void> delete(
            @PathVariable String id) {

        studentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}