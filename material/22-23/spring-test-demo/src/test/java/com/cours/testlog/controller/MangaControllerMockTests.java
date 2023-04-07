package com.cours.testlog.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import com.cours.testlog.service.MangaService;

// https://spring.io/guides/gs/testing-web/
@SpringBootTest
@AutoConfigureMockMvc
public class MangaControllerMockTests {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MangaService mangaService;

  @BeforeEach
  void setup() {
    mangaService.removeAll();
  }

  @Test
  public void testGetAll() throws Exception {
    this.mockMvc.perform(get("/manga"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("[]")));
  }

  @Test
  public void testAddOne() {

  }
}
