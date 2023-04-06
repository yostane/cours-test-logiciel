package com.example.project;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SortUtilsTests {
  @Test
  public void sortsAnIntArray() {
    assertArrayEquals(new int[] { 1, 2, 3 },
        SortUtils.sortWithBubbleMethod(new int[] { 3, 2, 1 }));

    assertArrayEquals(new int[] { -1, 3, 7, 11 },
        SortUtils.sortWithBubbleMethod(new int[] { 3, 7, -1, 11 }));
  }

  int[] convertToArray(String input) {
    return Stream.of(input.split("/")).mapToInt(c -> Integer.parseInt(c)).toArray();
  }

  @ParameterizedTest
  @CsvSource({
      "3/1/2, 1/2/3",
      "1/20/-3/100, -3/1/20/100",
  })
  public void sortsIntArrayFromCSV(String input, String expected) {
    int[] inputs = convertToArray(input);
    int[] expectedNumbers = convertToArray(expected);
    var result = SortUtils.sortWithBubbleMethod(inputs);
    assertArrayEquals(expectedNumbers, result,
        String.format("%s should sort to %s but got %s", Arrays.toString(inputs), Arrays.toString(expectedNumbers),
            Arrays.toString(result)));
  }
}
