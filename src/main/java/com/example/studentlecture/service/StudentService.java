package com.example.studentlecture.service;

import com.example.studentlecture.model.Student;
import com.example.studentlecture.model.StudentDto;
import com.example.studentlecture.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public List<Student> getStudentWithIdAboveJPA(Long id) {
        return studentRepository.findAllByIdGreaterThan(id);
    }

    public List<Student> getStudentWithIdAbove(Long id) {
        String sql = "SELECT * FROM students WHERE students.id > ?";
        return jdbcTemplate.query(sql, new StudentRowMapper(), id);
    }
    private static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setEmail(rs.getString("email"));
            return student;
        }
    }
}
