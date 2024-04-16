package com.example.moodle_api.service;

import com.example.moodle_api.model.Course;
import com.example.moodle_api.model.CourseModules;
import com.example.moodle_api.repository.CourseModuleRepository;
import com.example.moodle_api.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {

    private  final CourseRepository courseRepository;

    private final CourseModuleRepository courseModuleRepository;

    public List<Course> findAllCourses(){
        return (List<Course>) courseRepository.findAll();
    }

    public CourseModules addCourseModule(CourseModules courseModules){
        return courseModuleRepository.findByCourse(courseModules.getCourse())
                .orElseGet( ()-> courseModuleRepository.save(courseModules));
    }
    public Course add(Course course){

        var courseRef = courseRepository.findByFullNameContainsIgnoreCase(course.getFullName())
                .orElseGet( ()-> {
                    var returnCourse = courseRepository.save(course);
                    addCourseModule(CourseModules.builder()
                            .module(10L)
                            .visible(1)
                            .course(returnCourse.getId())
                            .instance(3L)
                            .build()
                    );
                    return returnCourse;
                });

        return  courseRef;

    }
}
