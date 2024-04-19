package com.example.moodle_api.repository;

import com.example.moodle_api.model.QuestionAnswer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, Long> {
}
