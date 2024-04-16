package com.example.moodle_api.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "mdl_course")
public class Course {

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "shortname")
    private String shortName;

    @Column(name = "summary")
    private String summary;

    @Column(name = "visible")
    private int visible;


    @Column(name = "timecreated", length = 10)
    private long timeCreated;

    @Column(name = "timemodified", length = 10)
    private long timeModified;

    @Column(name = "category")
    private int category;

    @Column(name = "format")
    private String format;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
