package com.example.studentlecture.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
