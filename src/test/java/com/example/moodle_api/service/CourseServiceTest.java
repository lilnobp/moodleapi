package com.example.moodle_api.service;

import com.example.moodle_api.model.Course;
import com.example.moodle_api.model.CourseModules;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseServiceTest {

    private  final CourseService courseService;
    @Test
    void add() {

        var course = Course.builder()
                .fullName("Sport Entertainment")
                .shortName("SPE")
                .visible(1)
                .summary("Tester")
                .timeModified(new Date().getTime())
                .timeCreated(new Date().getTime())
                .format("topics")
                .category(1)
                .build();

        assertNotNull(courseService.add(course));
    }

    @Test
    public void addCourseModule(){

        var courseModule = CourseModules.builder()
                .module(10L)
                .course(5)
                .visible(1)
                .instance(3)
                .build();

        assertNotNull(courseModule);
    }
}