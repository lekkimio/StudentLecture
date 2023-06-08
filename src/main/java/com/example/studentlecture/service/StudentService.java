package com.example.studentlecture.service;

import com.example.studentlecture.model.Student;
import com.example.studentlecture.model.StudentDto;
import com.example.studentlecture.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return null;
    }

    public Student getStudentById(Long id) {
        return null;
    }

    public Student addStudent(StudentDto student) {
        return null;
    }

    public void deleteStudentById(Long id) {

    }

    public Student updateStudentById(Long id, StudentDto student) {
        return null;
    }
}
