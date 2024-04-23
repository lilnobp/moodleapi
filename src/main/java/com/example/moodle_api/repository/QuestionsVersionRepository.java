package com.example.moodle_api.repository;

import com.example.moodle_api.model.QuestionVersion;
import org.springframework.data.repository.CrudRepository;

public interface QuestionsVersionRepository extends CrudRepository<QuestionVersion, Long> {
}
