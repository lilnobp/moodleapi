package com.example.moodle_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Entity
@Immutable
@Getter
@Table(name = "vw_question_version_unique")
@Subselect(" select * from vw_question_version_unique")
public class QuestionVersionCustomField implements Serializable {

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

    @Column(name = "versions")
    private Long version;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "instanceId", cascade = CascadeType.ALL)
    private Collection<CustomFieldDataCategory> properties = new LinkedHashSet<CustomFieldDataCategory>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)
    private Collection<QuestionAnswer> answers= new LinkedHashSet<QuestionAnswer>();

}
