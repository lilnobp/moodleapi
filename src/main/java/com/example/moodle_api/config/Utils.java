package com.example.moodle_api.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Array;
import java.util.List;

@Builder
public class Utils {

    public String getMeaningQuotes( String text){

        return  text.replaceAll("&#039;", "'")
                .replaceAll("&amp;#039;", "'")
                .replaceAll("&quot;", "'");

    }
}
