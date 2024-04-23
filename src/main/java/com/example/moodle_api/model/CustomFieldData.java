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

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mdl_customfield_data", schema = "moodle")
public class CustomFieldData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "fieldid")
    private long fielId;

    @Column(name = "instanceid")
    private long instanceId;

    @Column(name = "value")
    private String value;

    @Column(name = "charvalue")
    private String charValue;

    @Column(name = "valueformat")
    private long valueFormat;

    @Column(name = "timecreated")
    private long timeCreated;

    @Column(name = "timemodified")
    private long timeModified;

    @Column(name = "contextid")
    private long contextId;

}
