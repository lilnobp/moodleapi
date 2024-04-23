package com.example.moodle_api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Collection;
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

    @Column(name = "createdby")
    private Long createBy;

    @Column(name = "modifiedby")
    private Long modifiedBy;

    @Column(name = "generalfeedback")
    private  String generalfeedback;

    @Column(name = "generalfeedbackformat")
    private  int generalfeedbackFormat;

    @Column(name = "qtype")
    private  String qType;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)
    private Collection<QuestionAnswer> answers = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "questionid")
    private QuestionVersion version;
}
