package com.example.moodle_api.controller;

import com.example.moodle_api.model.Question;
import com.example.moodle_api.model.QuestionAnswer;
import com.example.moodle_api.model.CustomFieldDataCategory;
import com.example.moodle_api.model.QuestionVersionCustomField;
import com.example.moodle_api.repository.CustomFieldDataRepository;
import com.example.moodle_api.repository.QuestionVersionCustomFieldRepository;
import com.example.moodle_api.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private final CustomFieldDataRepository customFieldDataRepository;
    private final QuestionVersionCustomFieldRepository questionVersionCustomFieldRepository;
    @GetMapping("/all")
    public List<Question> getQuestion(){
        return  questionService.getQuestions();
    }

    @PostMapping("/answer")
    public Question insertQuestion( @RequestBody Question question){
        return questionService.insertQuestion(question);
    }

    @GetMapping("/customField")
    public List<CustomFieldDataCategory> getQuestionCustomField(@RequestParam long instanceId){
        return (List<CustomFieldDataCategory>) customFieldDataRepository.findAllById(instanceId);
    }


    @GetMapping("/customFields")
    public List<CustomFieldDataCategory> getQuestionCustomFields(){
        return (List<CustomFieldDataCategory>) customFieldDataRepository.findAll();
    }

    @GetMapping("/questionCustomFields")
    @Transactional
    public List<QuestionVersionCustomField> getQuestionVersionCustomFields(){
        var questions = questionVersionCustomFieldRepository.findAll();
        return (List<QuestionVersionCustomField>) questions;
    }

}
