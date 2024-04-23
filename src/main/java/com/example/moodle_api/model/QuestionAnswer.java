package com.example.moodle_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "question")
    private long question;

    @Column(name = "fraction")
    private double fraction;

    @Column(name = "feedbackformat")
    private int feedbackFormat;

    @Column(name = "answer")
    private String answer;

    @Column(name = "answerformat")
    private int answerFormat;

    @Column(name = "feedback")
    private String feedback;
}
