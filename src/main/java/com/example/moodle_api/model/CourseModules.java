package com.example.moodle_api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "mdl_course_modules", schema = "moodle")
public class CourseModules {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "course")
    private long course;

    @Column(name = "module")
    private long module;

    @Column(name = "instance")
    private long instance ;

    @Column(name = "visible")
    private int visible ;
}
