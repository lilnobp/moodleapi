package com.example.moodle_api.service;

import com.example.moodle_api.model.CustomFieldData;
import com.example.moodle_api.model.Question;
import com.example.moodle_api.model.QuestionAnswer;
import com.example.moodle_api.model.QuestionDto;
import com.example.moodle_api.repository.CustomFieldDataInputRepository;
import com.example.moodle_api.repository.QuestionAnswerRepository;
import com.example.moodle_api.repository.QuestionBankEntryRepository;
import com.example.moodle_api.repository.QuestionRepository;
import com.example.moodle_api.repository.QuestionsVersionRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionAnswerRepository questionAnswerRepository;
    private final QuestionsVersionRepository questionsVersionRepository;
    private final CustomFieldDataInputRepository customFieldDataInputRepository;
    private final QuestionBankEntryRepository questionBankEntryRepository;

    public QuestionDto insertQuestion( QuestionDto questionDto){
        var question = questionDto.getQuestion();
    questionRepository
        .findByQuestionTextEqualsIgnoreCase(question.getQuestionText())
        .orElseGet(
            () -> {
              var questionRef = questionRepository.save(questionDto.getQuestion());
              var questionRefName = questionRepository.findById(question.getId()).get();
              questionRefName.setName(question.getName()+ " " + questionRefName.getId());
              questionRepository.save(questionRefName);

              questionDto.setQuestion(questionRef);
              questionRef = addAnswersAndVersion(questionDto);
              var customDataFields = questionDto.getCustomFieldData();
              questionDto.setQuestion(questionRef);
              var customFieldData = new ArrayList<CustomFieldData>();
              for (var customDataField : customDataFields) {
                customDataField.setInstanceId(questionRef.getId());
                customFieldData.add(customFieldDataInputRepository.save(customDataField));
              }
              questionDto.setCustomFieldData(customFieldData);
              return questionRef;
            });

        return questionDto;
    }

    @PostConstruct
    public void getOpenTdbQuestion(){
        System.out.println("test .....");
    }


    private Question addAnswersAndVersion(QuestionDto questionDto){
        var question = questionDto.getQuestion();
        var returnAnswers = new ArrayList<QuestionAnswer>();
        for ( var answer : question.getAnswers()){
            var answerRef = questionAnswerRepository.findById(answer.getId()).get();
            answerRef.setQuestion(question.getId());
            answerRef = questionAnswerRepository.save(answerRef);
            returnAnswers.add(answerRef);
        }
        var questionBackEntry = questionDto.getQuestionBankEntry();
        questionBackEntry = questionBankEntryRepository.save(questionBackEntry);
        var version = questionsVersionRepository.findById(question.getVersion().getId()).get();
        version.setQuestion(question.getId());
        version.setQuestionBankEntryId(questionBackEntry.getId());
        version = questionsVersionRepository.save(version);
        question.setAnswers(returnAnswers);
        question.setVersion(version);
        return question;
    }
    public List<Question> getQuestions(){
        return (List<Question>) questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(long id){
        return questionRepository.findById(id);
    }

}
