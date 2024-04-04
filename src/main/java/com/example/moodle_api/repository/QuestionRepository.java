package com.example.moodle_api.repository;

import com.example.moodle_api.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository <Question, Long> {
}
