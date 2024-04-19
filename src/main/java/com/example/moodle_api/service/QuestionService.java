package com.example.moodle_api.service;

import com.example.moodle_api.model.Question;
import com.example.moodle_api.model.QuestionAnswer;
import com.example.moodle_api.repository.QuestionAnswerRepository;
import com.example.moodle_api.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question insertQuestion( Question question){
        return questionRepository.findByQuestionTextContainsIgnoreCase(question.getName())
                .orElseGet(() -> questionRepository.save(question));

    }

    public List<Question> getQuestions(){
        return (List<Question>) questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(long id){
        return questionRepository.findById(id);
    }

}
