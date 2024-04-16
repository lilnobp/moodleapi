package com.example.moodle_api.controller;

import com.example.moodle_api.model.Course;
import com.example.moodle_api.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/course/")
public class CourseController {

    private  final CourseService courseService;

    @GetMapping("all")
    public List<Course> getCourses(){
        return courseService.findAllCourses();
    }
}
