package com.project.school_manager.modules.student.service;

import com.project.school_manager.modules.student.Student;
import com.project.school_manager.modules.student.dto.StudentCreateDTO;
import com.project.school_manager.modules.student.dto.StudentResponseDTO;
import com.project.school_manager.modules.student.dto.StudentUpdateDTO;
import com.project.school_manager.modules.student.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public StudentResponseDTO findById(String id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aluno não encontrado: " + id));

        return toResponse(student);
    }

    public List<StudentResponseDTO> findByName(String name) {

        return studentRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public StudentResponseDTO create(StudentCreateDTO dto) {

        Student student = new Student();

        student.setName(dto.name());
        student.setGuardianName(dto.guardianName());
        student.setGuardianCpf(dto.guardianCpf());
        student.setPhone(dto.phone());
        student.setAddress(dto.address());

        studentRepository.save(student);

        return toResponse(student);
    }

    public StudentResponseDTO update(
            String id,
            StudentUpdateDTO dto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aluno não encontrado: " + id));

        student.setName(dto.name());
        student.setGuardianName(dto.guardianName());
        student.setGuardianCpf(dto.guardianCpf());
        student.setPhone(dto.phone());
        student.setAddress(dto.address());

        studentRepository.save(student);

        return toResponse(student);
    }

    public void delete(String id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aluno não encontrado: " + id));

        studentRepository.delete(student);
    }

    private StudentResponseDTO toResponse(Student student) {

        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getGuardianName(),
                student.getGuardianCpf(),
                student.getPhone(),
                student.getAddress()
        );
    }
}
