package com.example.project;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntersectionCountOccurencesTest {
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

  @Test
  @DisplayName("Test intersect")
  public void testIntersect() {
    List<String> list1 = List.of("a", "b", "c", "d");
    List<String> list2 = List.of("b", "c", "e", "f");
    Collection<String> intersection = Intersection.intersect(list1, list2);
    // moins bien
    assertEquals(2, intersection.size());
    assertTrue(intersection.contains("b"));
    assertTrue(intersection.contains("c"));
    // mieux
    assertEquals(List.of("b", "c"), intersection);
  }

}
