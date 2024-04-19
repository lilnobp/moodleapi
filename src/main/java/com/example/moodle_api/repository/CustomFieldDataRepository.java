package com.example.moodle_api.repository;
import com.example.moodle_api.model.CustomFieldDataCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomFieldDataRepository extends CrudRepository<CustomFieldDataCategory, Long> {

    @Query(
            nativeQuery = true,
            value = "select * from vw_custom_field_category_data where instanceid =:instanceId"
    )
    Iterable<CustomFieldDataCategory> findAllById(@Param("instanceId") long instanceId);
}
