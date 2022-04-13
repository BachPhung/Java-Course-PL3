package ParameterTable;

import java.util.ArrayList;
import java.util.Collections;

public class ParameterTable {
  public static void main(String[] args) {
    ArrayList<String> listNames = new ArrayList<>();
    int longestCountryName = 0;
    for (String name : args) {
      if (longestCountryName < name.length()) {
        longestCountryName = name.length();
      }
      listNames.add(name);
    }
    Collections.sort(listNames);
    int size = listNames.size();
    int firstWidest = ("" + size).length();
    int secondWidest = longestCountryName;
    int borderWidth = firstWidest + secondWidest + 7;
    String customFormat = "# %" + firstWidest + "s | %-" + secondWidest + "s #%n";
    for (int i = 0; i <= size * 2; i++) {
      if (i == 0 || i == size * 2) {
        for (int j = 0; j < borderWidth; j++) {
          System.out.print("#");
        }
        System.out.println();
        if (i == 0) {
          System.out.format(customFormat, Integer.toString(1), listNames.get(0));
        }
      }
      else if (i % 2 == 0) {
        System.out.format(customFormat, Integer.toString(i / 2 + 1), listNames.get(i / 2));
      }
      else if (i % 2 == 1) {
        if (i == size * 2 - 1)  continue;
        for (int j = 0; j < borderWidth; j++) {
          if (j == 0 || j == borderWidth - 1) {
            System.out.print("#");
          }
          else if (j == firstWidest + 3) {
            System.out.print("+");
          }
          else {
            System.out.print("-");
          }
        }
        System.out.println();
      }
    }
  }
}
