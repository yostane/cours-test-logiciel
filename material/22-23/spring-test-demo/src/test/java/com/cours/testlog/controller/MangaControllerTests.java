package com.cours.testlog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;

import com.cours.testlog.model.Manga;
import com.cours.testlog.service.MangaService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MangaControllerTests {
  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private MangaService mangaService;

  @BeforeEach
  void setup() {
    mangaService.removeAll();
  }

  @Test
  public void testGetAll() {
    // https://www.baeldung.com/spring-rest-template-list
    var response = restTemplate.getForEntity("/manga", Manga[].class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(0, response.getBody().length);

    Manga manga = new Manga();
    manga.setIsbn("sdsfds");
    manga.setName("my hero academia");
    manga.setNbPages(40);
    restTemplate.postForEntity("/manga", manga, Void.class);

    response = restTemplate.getForEntity("/manga", Manga[].class);
    assertNotNull(response.getBody());
    assertEquals(1, response.getBody().length);
    Manga responseManga = (Manga) response.getBody()[0];
    org.assertj.core.api.Assertions.assertThat(responseManga.getIsbn()).isEqualTo(manga.getIsbn());
    assertEquals(manga.getIsbn(), responseManga.getIsbn());
  }

  @Test
  public void testCannotAddSameIsbnTwice() {
    Manga manga = new Manga();
    manga.setIsbn("sdsfds");
    manga.setName("my hero academia");
    manga.setNbPages(40);
    var response = restTemplate.postForEntity("/manga", manga, Void.class);
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    manga.setIsbn("sdsfds");
    manga.setName("my hero academia");
    manga.setNbPages(40);
    response = restTemplate.postForEntity("/manga", manga, Void.class);
    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }
}
