package com.example.studentlecture.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "classrooms")
@Data
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "classrooms_students",
            joinColumns = @JoinColumn(name = "class_room_id"),
            inverseJoinColumns =
                @JoinColumn(name = "students_id",
                            foreignKey =
                                @ForeignKey(
                                        name = "fk_classrooms_students_students_id",
                                        foreignKeyDefinition = "FOREIGN KEY (students_id) REFERENCES students(id) ON DELETE CASCADE ON UPDATE CASCADE"))
    )
    private Set<Student> students = new LinkedHashSet<>();

}
