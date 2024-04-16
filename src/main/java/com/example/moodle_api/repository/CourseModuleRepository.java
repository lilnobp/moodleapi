package com.example.moodle_api.repository;


import com.example.moodle_api.model.CourseModules;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseModuleRepository extends CrudRepository<CourseModules, Long> {
    Optional<CourseModules> findByCourse(Long courseId);
}
