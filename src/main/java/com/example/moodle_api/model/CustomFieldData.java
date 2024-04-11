package com.example.moodle_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;

@Getter
@Entity
@Immutable
@Table(name = "vw_custom_field_category_data")
@Subselect( "select * from vw_custom_field_category_data ")
public class CustomFieldData implements Serializable {

    @Column(name = "property_name")
    private String propertyName;

    @Column(name = "value")
    private String value;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "instanceid")
    private long instanceId;

    @Id
    @Column(name = "id")
    private long id;

}
