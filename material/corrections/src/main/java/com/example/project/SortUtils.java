package com.example.project;

public class SortUtils {
  public static int[] sortWithBubbleMethod(int[] numbers) {
    int[] sortedNumbers = numbers.clone();
    for (int i = sortedNumbers.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (sortedNumbers[j + 1] < sortedNumbers[j]) {
          // Echanger les deux valeurs
          int temp = sortedNumbers[j + 1];
          sortedNumbers[j + 1] = sortedNumbers[j];
          sortedNumbers[j] = temp;
        }
      }
    }
    return sortedNumbers;
  }
}
