package com.example.moodle_api.repository;

import com.example.moodle_api.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findByFullNameContainsIgnoreCase(String fullName);
}
