package com.example.moodle_api.controller;

import com.example.moodle_api.model.Question;
import com.example.moodle_api.model.QuestionAnswer;
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

}
