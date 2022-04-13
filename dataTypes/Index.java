package dataTypes;

import java.util.HashSet;
import java.util.TreeSet;

public class Index {
  public static void main(String[] args) {
    HashSet<String> hashSet = new HashSet<>();
    TreeSet<String> sets = new TreeSet<>();
    sets.add("quang");
    sets.add("bach");
    hashSet.addAll(sets);
    for (String s : sets) {
      System.out.println(s + " ");
    }

  }
}