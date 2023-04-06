package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author graffion
 *
 */
public class MyDateTests {

  /**
   * Test method for {@link MyDate#getDay()}.
   */
  @Test
  public void testGetDay() {
    MyDate d = new MyDate(31, 12, 2006);
    assertEquals(31, d.getDay());
  }

  /**
   * Test method for {@link MyDate#getMonth()}.
   * C'est mieux de le faire en parametrized pour ne pas avoir à saisir deux fois
   * le même code
   */
  @Test
  public void testGetMonth() {
    MyDate d = new MyDate(31, 12, 2006);
    assertEquals(12, d.getMonth());
    d = new MyDate(31, 1, 2006);
    assertEquals(1, d.getMonth());
  }

  /**
   * Test method for {@link MyDate#getYear()}.
   */
  @ParameterizedTest
  @CsvSource({
      "2012",
      "10",
      "2023"
  })
  public void testGetYear(int year) {
    MyDate d = new MyDate(31, 12, year);
    assertEquals(year, d.getYear());
  }

  /**
   * Test method for {@link MyDate#checkData()} .
   */
  @ParameterizedTest
  @CsvSource({
      "1, 1, 2012, true",
      "45, 1, 2012, false",
      "29, 2, 2012, true",
      "29, 2, 2011, false",
  })
  public void testCheckData(int day, int month, int year, boolean expected) {
    MyDate d = new MyDate(day, month, year);
    assertEquals(expected, d.checkData(),
        String.format("Date %d/%d/%d validity should be %b: , ", day, month, year, expected));
  }

  /**
   * Test simple valid dates
   */
  @Test
  public void testSimpleValidDates() {
    boolean b = MyDate.isValidDate(1, 1, 2000);
    assertTrue(b);
    b = MyDate.isValidDate(25, 12, 2000);
    assertTrue(b);
  }

  /**
   * Test simple invalid dates
   */
  @Test
  public void testSimpleInvalidDates() {
    boolean b = MyDate.isValidDate(0, 1, 2000);
    assertFalse(b, "0 est invalide pour le jour");
    b = MyDate.isValidDate(32, 12, 2000);
    assertFalse(b);
  }

  /**
   * Test valid limit dates
   */
  @Test
  public void testValidLimitDates() {
    boolean b = MyDate.isValidDate(31, 1, 2000);
    assertTrue(b, "31 janvier est une date valide");
  }

  /**
   * Test invalid limit dates
   */
  @Test
  public void testInvalidLimitDates() {
    boolean b = MyDate.isValidDate(31, 4, 2000);
    assertFalse(b, "31 avril est une date invalide");
  }

  /**
   * Test February valid limit dates
   */
  @Test
  public void testFebruaryValidLimitDates() {
    assertTrue(MyDate.isValidDate(29, 2, 2000), "29 février 2000 est une date valide");
  }

  /**
   * Test February invalid limit dates
   */
  @Test
  public void testFebruaryInvalidLimitDates() {
    boolean b = MyDate.isValidDate(29, 2, 2001);
    assertFalse(b, "29 février 2001 est une date invalide");
  }

  @ParameterizedTest
  @CsvSource({
      "1, 1, 0, 2, 1, 0",
      "28, 2, 2000, 29, 2, 2000",
      "28, 2, 2001, 1,3 , 2001",
      "30, 4, 2001, 1, 5, 2001",
      "31, 12, 2012, 1, 1, 2013"
  })
  public void addsOneDay(int day, int month, int year, int expectedDay, int expectedMonth, int expectedYear) {
    MyDate d = new MyDate(day, month, year);
    d.nextDay();
    assertEquals(expectedDay, d.getDay());
    assertEquals(expectedMonth, d.getMonth());
    assertEquals(expectedYear, d.getYear());
  }

}
