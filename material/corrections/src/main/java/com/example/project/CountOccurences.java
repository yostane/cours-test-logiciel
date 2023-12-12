package com.example.project;

import java.util.stream.Collectors;

record Pair(char key, long value) {

}

public class CountOccurences {

  public static void count(String text) {
    var inputText = text.toLowerCase();
    var countMap = inputText.chars().distinct().mapToObj((c) -> {
      // Compte le nombre d'occurences de chaque caractère disctict
      long count = inputText.chars().filter(t -> t == c).count();
      // Retourne un objet avec le caractère et le nombre d'occurences
      return new Pair((char) c, count);
    }).collect(Collectors.toMap(pair -> pair.key(), pair -> pair.value()));
    // Collect permet de générer un dictionnaire à partir de la liste d'objets

    // Affichage
    for (var entry : countMap.entrySet()) {
      System.out.println(String.format("%c -> %d", entry.getKey(), entry.getValue()));
    }
  }
}
