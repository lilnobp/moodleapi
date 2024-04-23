package com.example.moodle_api.service;

import com.example.moodle_api.config.openTdb.OpenTdbRequest;
import com.example.moodle_api.model.QuestionDto;
import com.example.moodle_api.model.QuestionVersionCustomField;
import com.example.moodle_api.repository.QuestionVersionCustomFieldRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class QuestionServiceTest {

    private final QuestionVersionCustomFieldRepository questionVersionCustomFieldRepository;
    private final QuestionService questionService;

    @Test
    void getQuestions() {
        List<QuestionVersionCustomField> questionsContext = (List<QuestionVersionCustomField>) questionVersionCustomFieldRepository
                .findAll();

        assertNotNull(questionsContext);
    }

    @Test
    void getQuestionById() {
    }

    @Test
    void openTdbMoodleQuestionMath(){
        var category = 19;
        var max =40;
        var questionTitle = "Computer Mathematics";
        var questionCategoryId = 24L;
        var contextId = 2359L;
        var openTdbRequest = new OpenTdbRequest();
        var questionDtoList =openTdbRequest.convertOpenTdbToQuestionDto(
                questionTitle,
                questionCategoryId,
                max,
                category,
                contextId);

        var emptyQuestionDto = new ArrayList<QuestionDto>();
        for ( var questionDto : questionDtoList){
            emptyQuestionDto.add(questionService.insertQuestion(questionDto));
        }
        assertNotNull(emptyQuestionDto);

    }

    @Test
    void openTdbMoodleQuestionGeography(){
        var category = 22;
        var max =40;
        var questionTitle = "Geography";
        var questionCategoryId = 30L;
        var contextId = 2361L;
        var openTdbRequest = new OpenTdbRequest();
        var questionDtoList =openTdbRequest.convertOpenTdbToQuestionDto(
                questionTitle,
                questionCategoryId,
                max,
                category,
                contextId);

        var emptyQuestionDto = new ArrayList<QuestionDto>();
        for ( var questionDto : questionDtoList){
            emptyQuestionDto.add(questionService.insertQuestion(questionDto));
        }
        assertNotNull(emptyQuestionDto);

    }

    @Test
    void openTdbMoodleQuestionComputerScience(){
        var category = 18;
        var max =40;
        var questionTitle = "Computer Sciences";
        var questionCategoryId = 28L;
        var contextId = 2357L;
        var openTdbRequest = new OpenTdbRequest();
        var questionDtoList =openTdbRequest.convertOpenTdbToQuestionDto(
                questionTitle,
                questionCategoryId,
                max,
                category,
                contextId);

        var emptyQuestionDto = new ArrayList<QuestionDto>();
        for ( var questionDto : questionDtoList){
            emptyQuestionDto.add(questionService.insertQuestion(questionDto));
        }
        assertNotNull(emptyQuestionDto);

    }
}