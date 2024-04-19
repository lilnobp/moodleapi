package com.example.moodle_api.service;

import com.example.moodle_api.model.QuestionVersionCustomField;
import com.example.moodle_api.repository.QuestionVersionCustomFieldRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class QuestionServiceTest {


    private final QuestionVersionCustomFieldRepository questionVersionCustomFieldRepository;
    @Test
    void insertQuestion() {
    }

    @Test
    void getQuestions() {
        List<QuestionVersionCustomField> questionsContext = (List<QuestionVersionCustomField>) questionVersionCustomFieldRepository
                .findAll();

        assertNotNull(questionsContext);
    }

    @Test
    void getQuestionById() {
    }
}