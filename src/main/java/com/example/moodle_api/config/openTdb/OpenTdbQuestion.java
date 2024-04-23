package com.example.moodle_api.config.openTdb;

import com.example.moodle_api.config.Utils;
import lombok.Getter;
import lombok.Setter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class OpenTdbQuestion {

    @Setter
    private String type;

    private Utils utils;
    public OpenTdbQuestion(){
        utils = Utils.builder().build();
    }
    @Setter
    private String difficulty;

    public String getType() {
        return utils.getMeaningQuotes(type);
    }

    public String getDifficulty() {
        return utils.getMeaningQuotes(difficulty);
    }

    public String getQuestion() {
        return utils.getMeaningQuotes(question);
    }

    public String getCorrect_answer() {
        return utils.getMeaningQuotes(correct_answer);
    }

    public Collection<String> getIncorrect_answers() {
        var inCorrect = new HashSet<String>();
        for (var inCorrectAnswer : incorrect_answers){
            inCorrect.add(utils.getMeaningQuotes(inCorrectAnswer));
        }
        return inCorrect;
    }

    @Setter
    @Getter
    private  String category;

    @Setter
    private  String question;

    @Setter
    private String correct_answer;

    @Setter
    private List<String> incorrect_answers;
}
