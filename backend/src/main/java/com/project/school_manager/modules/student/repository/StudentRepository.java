package com.project.school_manager.modules.student.repository;

import com.project.school_manager.modules.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByNameContainingIgnoreCase(String name);
}
