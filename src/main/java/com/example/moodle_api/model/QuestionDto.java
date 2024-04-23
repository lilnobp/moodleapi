package com.example.moodle_api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
public class QuestionDto {

    private Question question;

    private Collection<CustomFieldData> customFieldData;

    private QuestionBankEntry questionBankEntry;

}
