package com.example.moodle_api.config.openTdb;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
public class OpenTdb {

    private String  response_code;
    private Collection<OpenTdbQuestion> results;

}
