package com.cours.testlog.model;

public class Manga {
  private String isbn;
  private String name;
  private int nbPages;

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNbPages() {
    return nbPages;
  }

  public void setNbPages(int nbPages) {
    this.nbPages = nbPages;
  }
}