package com.cours.testlog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cours.testlog.model.Manga;

@Service
public class MangaService {
  static List<Manga> mangas = new ArrayList<>();

  public List<Manga> getAll() {
    return mangas;
  }

  public boolean addOne(Manga manga) {
    if (manga.getIsbn() == null || mangas.stream().anyMatch(m -> m.getIsbn().equals(manga.getIsbn()))) {
      return false;
    }
    mangas.add(manga);
    return true;
  }

  public void removeAll() {
    mangas.clear();
  }
}
