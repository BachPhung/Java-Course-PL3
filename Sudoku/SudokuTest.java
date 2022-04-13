package Sudoku;

public class SudokuTest {
    public static void main(String[] args) {
        SudokuGame a = new SudokuGame();
        a.set(3, 5, '1');
        a.set(5, 6, '1');
        a.check();
    }
}
