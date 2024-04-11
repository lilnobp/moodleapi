package com.example.moodle_api.repository;

import com.example.moodle_api.model.CustomFieldData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomFieldDataRepository extends CrudRepository<CustomFieldData, Long> {


    @Query(
            nativeQuery = true,
            value = "select * from vw_custom_field_category_data where instanceid =:instanceId"
    )
    Iterable<CustomFieldData> findAllById(@Param("instanceId") long instanceId);
}
