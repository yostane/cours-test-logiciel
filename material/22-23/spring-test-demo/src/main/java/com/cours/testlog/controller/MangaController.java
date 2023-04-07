package com.cours.testlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cours.testlog.model.Manga;
import com.cours.testlog.service.MangaService;

@RestController
@RequestMapping("/manga")
public class MangaController {

  @Autowired
  MangaService mangaService;

  @GetMapping
  public List<Manga> getAll() {
    return mangaService.getAll();
  }

  @PostMapping
  public ResponseEntity<Void> addOne(@RequestBody Manga manga) {
    if (mangaService.addOne(manga)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.badRequest().build();
  }
}
