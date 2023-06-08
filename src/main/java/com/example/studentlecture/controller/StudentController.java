package com.example.studentlecture.controller;

import com.example.studentlecture.model.Student;
import com.example.studentlecture.model.StudentDto;
import com.example.studentlecture.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/id-above/{id}")
    public List<Student> getStudentWithIdAbove(@PathVariable Long id) {
        return studentService.getStudentWithIdAbove(id);
    }
    @GetMapping("/id-above-jpa/{id}")
    public List<Student> getStudentWithIdAboveJpa(@PathVariable Long id) {
        return studentService.getStudentWithIdAboveJPA(id);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(StudentDto student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @PatchMapping("/{id}")
    public Student updateStudentById(@PathVariable Long id, StudentDto student) {
        return studentService.updateStudentById(id, student);
    }
}
