package com.example.moodle_api.repository;

import com.example.moodle_api.model.QuestionVersionCustomField;
import org.springframework.data.repository.CrudRepository;

public interface QuestionCustomFieldDataRepository extends CrudRepository<QuestionVersionCustomField, Long> {
}
