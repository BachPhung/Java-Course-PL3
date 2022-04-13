package Sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SudokuGame {
  private final int ROW = 9;
  private final int COL = 9;
  private ArrayList<Character[]> grid = new ArrayList<>();
  List<Character> charList = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));

  public SudokuGame() {
    for (int i = 0; i < this.ROW; i++) {
      Character[] charTemp = new Character[9];
      for (int j = 0; j < this.COL; j++) {
        charTemp[j] = ' ';
      }
      grid.add(charTemp);
    }
  }

  public void set(int i, int j, char c) {
    try {
      if (!((i >= 0 && i <= 8) || (j >= 0 && j <= 8))) {
        String errorStr = String.format("Trying to access illigal cell (%d,%d)!", i, j);
        throw new Exception(errorStr);
      } else if (!charList.contains(c)) {
        String errorStr = String.format("Trying to set illegal character %c to (%d,%d)!", c, i, j);
        throw new Exception(errorStr);
      } else {
        this.grid.get(i)[j] = c;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public boolean check() {
    try {
      // CHECK DUPLICATE DIGIT CHAR IN ROWS AND COLUMNS
      for (int i = 0; i < this.ROW; i++) {
        for (int k = 0; k < this.COL - 1; k++) {
          for (int j = k + 1; j < this.COL; j++) {
            if (this.grid.get(i)[k].equals(this.grid.get(i)[j])) {
              String errorStr = String.format("Row %d has multiple c's!", i);
              throw new Exception(errorStr);
            } else if (this.grid.get(k)[i].equals(this.grid.get(k)[j])) {
              String errorStr = String.format("Row %d has multiple c's!", j);
              throw new Exception(errorStr);
            }
          }
        }
      }

      // CHECK DUPLICATE DIGIT CHAR IN SUB-BLOCKS
      for (int i = 0; i < (ROW / 3) + 3; i += 3) {
        for (int j = 0; j < (COL / 3) + 3; j += 3) {
          HashSet<Character> valueSet = new HashSet<>();
          for (int m = i; m < i + 3; m++) {
            for (int n = j; n < j + 3; n++) {
              if (!valueSet.add(this.grid.get(m)[n])) {
                String errorStr = String.format("Block at (%d,%d) has multiple c's!", i, j);
                throw new Exception(errorStr);
              }
            }
          }
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }
}
