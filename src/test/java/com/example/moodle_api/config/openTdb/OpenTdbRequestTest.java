package com.example.moodle_api.config.openTdb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class OpenTdbRequestTest {

    @Test
    void convertOpenTdbToQuestionDto() {
        var category = 18;
        var max =2;
        var questionTitle = "Computer Science";
        var questionCategoryId = 28L;
        var contextId = 28L;
        var openTdbRequest = new OpenTdbRequest();
        var questionDtoList =openTdbRequest.convertOpenTdbToQuestionDto(
                questionTitle,
                questionCategoryId,
                max,
                category,contextId);
        assertNotNull(questionDtoList);
    }

    @Test
    void getDataOpenTdb() {
        var category = 18;
        var max =2;
        var openTdbRequest = new OpenTdbRequest();
        var opens = openTdbRequest.getDataOpenTdb(max, category);
        assertEquals(max, opens.getResults().size());
    }
}