package com.example.moodle_api.repository;

import com.example.moodle_api.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface QuestionRepository extends CrudRepository <Question, Long> {
    Optional<Question> findByQuestionTextContainsIgnoreCase(String name);
}
