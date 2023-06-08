package com.example.studentlecture.repo;

import com.example.studentlecture.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByIdGreaterThan(Long id);

}
