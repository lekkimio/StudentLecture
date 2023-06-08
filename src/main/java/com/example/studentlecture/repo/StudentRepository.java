package com.example.studentlecture.repo;

import com.example.studentlecture.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
