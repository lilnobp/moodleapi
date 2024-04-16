package com.example.moodle_api.controller;

import com.example.moodle_api.model.Question;
import com.example.moodle_api.model.QuestionAnswer;
import com.example.moodle_api.model.CustomFieldDataCategory;
import com.example.moodle_api.model.QuestionVersionCustomField;
import com.example.moodle_api.repository.CustomFieldDataRepository;
import com.example.moodle_api.repository.QuestionCustomFieldDataRepository;
import com.example.moodle_api.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private final CustomFieldDataRepository customFieldDataRepository;
    private final QuestionCustomFieldDataRepository questionCustomFieldDataRepository;
    @GetMapping("/all")
    public List<Question> getQuestion(){
        return  questionService.getQuestions();
    }

    @GetMapping("/answer")
    public Optional<List<QuestionAnswer>> getQuestionAnswers(@RequestParam long id){
        return  questionService.getListQuestionAnswer(id);
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
    public List<QuestionVersionCustomField> getQuestionVersionCustomFields(){
        return (List<QuestionVersionCustomField>) questionCustomFieldDataRepository.findAll();
    }

}
