package com.example.project;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CountOccurencesTest {
  ByteArrayOutputStream bos;
  PrintStream originalOut;

  // Sera appelé avant chaque fonction de test
  @BeforeEach
  public void interceptSysout() {
    bos = new ByteArrayOutputStream();
    PrintStream customOut = new PrintStream(bos);
    originalOut = System.out;
    System.setOut(customOut);
  }

  // Sera appelé après chaque fonction de test
  @AfterEach
  public void restoreSysout() {
    System.setOut(originalOut);
  }

  @Test
  public void countsOcurrences() throws IOException {
    CountOccurences.count("Hello");
    bos.flush();
    var output = bos.toString();
    assertTrue(output.contains("h -> 1"));
    assertTrue(output.contains("e -> 1"));
    assertTrue(output.contains("l -> 2"));
    assertTrue(output.contains("o -> 1"));
    assertFalse(output.contains("a -> 1"));

    String[] outputLines = output.split(System.lineSeparator());
    Arrays.sort(outputLines);
    var expextedLines = List.of("e -> 1", "h -> 1", "l -> 2", "o -> 1");
    assertLinesMatch(expextedLines, Arrays.asList(outputLines));
  }

}
