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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name ="mdl_question_versions", schema = "moodle")
public class QuestionVersion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "version")
    private long version;

    @Column(name = "questionid")
    private long question;

    @Column(name = "questionbankentryid")
    private long questionBankEntryId;

    @Column(name = "status")
    private String status;
}
