package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTests {

  @Test
  void convertsToUpperCase() {
    assertEquals("HELLO", "HelLo".toUpperCase());
  }

  @ParameterizedTest(name = "{0} to lower case is = {1}")
  @CsvSource({
      "HeLLo,    hello",
      "WORLD,    world",
      "JaVa,  java"
  })
  void convertsLowerCase(String input, String expected) {
    assertEquals(expected, input.toLowerCase(), input + " to lowser case should be " + expected);
  }

}
