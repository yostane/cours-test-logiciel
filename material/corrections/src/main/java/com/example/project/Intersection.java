package com.example.project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Intersection {

  public static Collection<String> computeIntersection(List<String> leftItems, List<String> rightItems) {
    // Pour ne pas modifier leftItems
    var copyLeftItems = new ArrayList<String>(leftItems);
    copyLeftItems.retainAll(rightItems);
    return copyLeftItems;
  }

  public static Collection<String> intersect(List<String> leftItems, List<String> rightItems) {
    return leftItems.stream().filter((leftItem) -> rightItems.contains(leftItem)).toList();
  }

  public static Collection<String> intersect2(List<String> leftItems, List<String> rightItems) {
    return leftItems.stream().filter(rightItems::contains).toList();
  }
}
