package com.example.moodle_api.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

  @Test
  void getMeaningQuotes() {
    var text = "Captures what&#039;s on the screen and copies it to your clipboard";
    var utils = new Utils();
    assertEquals("Captures what's on the screen and copies it to your clipboard", utils.getMeaningQuotes(text));
  }
}
