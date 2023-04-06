package com.example.project;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

public class ExceptionDemoTests {
  @Test
  public void throwsException() {

    assertDoesNotThrow(() -> {
      var exceptionDemo = new ExceptionDemo();
      exceptionDemo.generateExceptionIfFalse(true);
    });

    assertThrowsExactly(IllegalArgumentException.class, () -> {
      var exceptionDemo = new ExceptionDemo();
      exceptionDemo.generateExceptionIfFalse(false);
    });

    // à titre indicatif
    assertThrows(Exception.class, () -> {
      var exceptionDemo = new ExceptionDemo();
      exceptionDemo.generateExceptionIfFalse(false);
    });

    assertThrows(RuntimeException.class, () -> {
      var exceptionDemo = new ExceptionDemo();
      exceptionDemo.generateExceptionIfFalse(false);
    });
  }
}
