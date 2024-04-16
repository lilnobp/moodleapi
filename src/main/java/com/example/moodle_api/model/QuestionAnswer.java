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
public class QuestionAnswer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "question", referencedColumnName = "id")
    private Question question;

    @Column(name = "fraction")
    private double fraction;

    @Column(name = "answer")
    private String answer;

}
