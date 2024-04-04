package com.example.moodle_api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "mdl_question", schema = "moodle")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "questiontext")
    private String questionText;

    @Column(name = "name")
    private String name;

    @Column(name = "stamp")
    private String stamp;

    @Column(name = "length")
    private Long length;

    @Column(name = "duration")
    private int duration;

}
