package com.example.studentlecture.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "classrooms")
@Data
public class ClassRoom {

    @Id
    private Long id;

    private String studentCount;

    @OneToMany
    private Set<Student> students;
}
