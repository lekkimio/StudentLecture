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

    private final StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
    }

    public Student addStudent(StudentDto student) {

        return studentRepository.save( Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build());
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudentById(Long id, StudentDto studentDto) {
        Student student = getStudentById(id);

        if (studentDto.getFirstName() != null) {
            student.setFirstName(studentDto.getFirstName());
        }
        if (studentDto.getLastName() != null) {
            student.setLastName(studentDto.getLastName());
        }
        if (studentDto.getEmail() != null) {
            student.setEmail(studentDto.getEmail());
        }

        return studentRepository.save(student);
    }
}
