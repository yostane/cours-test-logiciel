package com.example.project;

enum ErrorCode {
  Sucess,
  FailureIllegalArgument
}

public class ExceptionDemo {

  public boolean generateExceptionIfFalse(boolean test) throws IllegalArgumentException {
    if (test == false) {
      throw new IllegalArgumentException();
    }
    return true;
  }

  public ErrorCode generateError(boolean test) {
    if (test == false) {
      return ErrorCode.FailureIllegalArgument;
    }
    return ErrorCode.Sucess;
  }

  void checkError() {
    if (generateError(false) == ErrorCode.FailureIllegalArgument) {
      System.out.println("An error occured");
    }

    try {
      System.out.println(generateExceptionIfFalse(false));
      System.out.println("hello");
    } catch (IllegalArgumentException e) {

    }

  }

}
