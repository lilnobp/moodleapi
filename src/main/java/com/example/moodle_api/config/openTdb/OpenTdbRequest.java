package com.example.moodle_api.config.openTdb;

import com.example.moodle_api.model.CustomFieldData;
import com.example.moodle_api.model.Question;
import com.example.moodle_api.model.QuestionAnswer;
import com.example.moodle_api.model.QuestionBankEntry;
import com.example.moodle_api.model.QuestionDto;
import com.example.moodle_api.model.QuestionVersion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class OpenTdbRequest {

    public Collection<QuestionDto> convertOpenTdbToQuestionDto(
                                                               String questionTitle,
                                                               long questionCategoryId,
                                                               int max,
                                                               int category,
                                                               long contextId){
        var openTdb = getDataOpenTdb(max,category);
        var questionDtoList = new ArrayList<QuestionDto>();
        for (var openTdbResult : openTdb.getResults()){
            var answers = openTdbResult.getIncorrect_answers();
            var questionAnswers = new ArrayList<QuestionAnswer>();
            for (var answer : answers){
                questionAnswers.add(addQuestionAnswer(answer, openTdbResult.getType(), 0L));
            }
            questionAnswers.add(addQuestionAnswer(openTdbResult.getCorrect_answer(), openTdbResult.getType(), 1L));
            Collections.shuffle(questionAnswers);

            var qType = openTdbResult.getType().equalsIgnoreCase("boolean")? "truefalse":"multichoice";
            var question =
                  Question.builder()
                          .createBy(2L)
                          .questionText(openTdbResult.getQuestion())
                          .name(questionTitle )
                          .modifiedBy(2L)
                          .length(1L)
                          .generalfeedback("")
                          .stamp("192.168.0.112")
                          .generalfeedbackFormat(1)
                          .qType(qType)
                          .answers(questionAnswers)
                          .version(QuestionVersion.builder()
                                  .questionBankEntryId(9L)
                                  .status("ready")
                                  .version(1L)
                                  .build())
                      .build();

            questionDtoList.add(
                    QuestionDto.builder()
                            .question(question)
                            .customFieldData(getCustomFieldProperty(openTdbResult, contextId))
                            .questionBankEntry(
                                    QuestionBankEntry.builder()
                                            .questionCategoryId(questionCategoryId)
                                            .ownerId(2L)
                                            .idNumber("")
                                            .build()
                            )
                            .build()
            );

        }
        return questionDtoList;
    }
    private List<CustomFieldData> getCustomFieldEasy(long contentId){
        return new ArrayList<>(
                Arrays.asList(CustomFieldData.builder()
                                .value("1")
                                .fielId(3L)
                                .valueFormat(1L)
                                .timeCreated(1713569434)
                                .contextId(contentId)
                                .charValue("1")
                                .build(),
                        CustomFieldData.builder()
                                .value("easy")
                                .fielId(2L)
                                .timeCreated(1713569434)
                                .valueFormat(1L)
                                .contextId(contentId)
                                .charValue("easy")
                                .build(),
                        CustomFieldData.builder()
                                .value("60000")
                                .fielId(1L)
                                .timeCreated(1713569434)
                                .valueFormat(1L)
                                .contextId(contentId)
                                .charValue("60000")
                                .build()
                ));
    }

    private List<CustomFieldData> getCustomFieldMedium(long contextId){
        return new ArrayList<>(
                Arrays.asList(CustomFieldData.builder()
                                .value("2")
                                .fielId(3L)
                                .valueFormat(1L)
                                .timeCreated(1713569434)
                                .contextId(contextId)
                                .charValue("2")
                                .build(),
                        CustomFieldData.builder()
                                .value("medium")
                                .fielId(2L)
                                .timeCreated(1713569434)
                                .valueFormat(1L)
                                .contextId(contextId)
                                .charValue("medium")
                                .build(),
                        CustomFieldData.builder()
                                .value("120000")
                                .fielId(1L)
                                .timeCreated(1713569434)
                                .contextId(contextId)
                                .charValue("12000")
                                .valueFormat(1L)
                                .build()
                ));
    }

    private List<CustomFieldData> getCustomFieldHard(long contextId){
        return new ArrayList<>(
                Arrays.asList(CustomFieldData.builder()
                                .value("3")
                                .fielId(3L)
                                .valueFormat(1L)
                                .timeCreated(1713569434)
                                .contextId(contextId)
                                .charValue("3")
                                .build(),
                        CustomFieldData.builder()
                                .value("hard")
                                .fielId(2L)
                                .timeCreated(1713569434)
                                .valueFormat(1L)
                                .contextId(contextId)
                                .charValue("hard")
                                .build(),
                        CustomFieldData.builder()
                                .value("180000")
                                .fielId(1L)
                                .contextId(contextId)
                                .charValue("180000")
                                .timeCreated(1713569434)
                                .valueFormat(1L)
                                .build()
                ));
    }
    private List<CustomFieldData> getCustomFieldProperty(OpenTdbQuestion openTdbQuestion, long contextId){
        if(openTdbQuestion.getDifficulty().equalsIgnoreCase("easy")){
            return getCustomFieldEasy(contextId);
        }
        if(openTdbQuestion.getDifficulty().equalsIgnoreCase("medium")){
            return getCustomFieldMedium(contextId);
        }
        if(openTdbQuestion.getDifficulty().equalsIgnoreCase("hard")){
            return getCustomFieldHard(contextId);
        }

        return new ArrayList<>();
    }
    private QuestionAnswer addQuestionAnswer(String answer, String type, long fraction){

        if(type.equals("boolean")){
            return QuestionAnswer.builder()
                    .answer(answer)
                    .feedback("XX" + type)
                    .fraction(fraction)
                    .feedbackFormat(1)
                    .answerFormat(0)
                    .build();
        }
        return  QuestionAnswer.builder()
                .answer(answer)
                .feedback("XX" + type)
                .fraction(fraction)
                .feedbackFormat(1)
                .answerFormat(1)
                .build();
    }
    private final String url = "https://opentdb.com/api.php?amount=@amt&category=@cat";
    public OpenTdb getDataOpenTdb(int max, int category)  {
        var dataJson = getDataFromUrl(url.replace("@amt", String.valueOf(max))
                .replace("@cat", String.valueOf(category)));
        ObjectMapper objectMapper = new ObjectMapper();
        OpenTdb openTdb = null;
        try {
            openTdb = objectMapper.readValue(dataJson, OpenTdb.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return openTdb;
    }

    private  String getDataFromUrl(String url)  {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (
            IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }

}
