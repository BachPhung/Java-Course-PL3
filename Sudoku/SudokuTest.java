package Sudoku;


public class SudokuTest {
    public static void main(String[] args) {
        SudokuGame a = new SudokuGame();
        a.set(0, 0, '1');
        a.set(0, 1, '2');
        a.set(0, 2, '3');
        a.set(0, 3, '4');
        a.set(0, 4, '5');
        a.set(0, 5, '6');
        a.set(0, 6, '7');
        a.set(0, 7, '8');
        a.set(0, 8, '9');
        a.set(1, 0, '1');
        a.set(1, 1, '2');
        a.set(1, 2, '3');
        a.set(1, 3, '4');
        a.set(1, 4, '5');
        a.set(1, 5, '6');
        a.set(1, 6, '7');
        a.set(1, 7, '8');
        a.set(1, 8, '9');
        a.print();
        a.check();
    }
}
