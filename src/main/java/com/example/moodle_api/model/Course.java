package com.example.moodle_api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "mdl_course")
public class Course {

    private String fullName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
