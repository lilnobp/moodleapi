package com.example.moodle_api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mdl_question_answers", schema = "moodle")
public class QuestionAnswerCto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column(name = "question")
    private long question;

    @Column(name = "id", insertable = false, updatable = false)
    private long value;

    /**
    @Column(name = "fraction")
    private double fraction;
     will be should TODO
     */

    @Column(name = "answer")
    private String text;

}
