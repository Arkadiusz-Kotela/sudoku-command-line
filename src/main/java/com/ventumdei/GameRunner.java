package com.ventumdei;

import java.util.Scanner;

import static com.ventumdei.BoardConstants.SIZE;

public class GameRunner {
    private SudokuProcessor processor = new SudokuProcessor();
    private int[][] puzzlesToSolve;
    private Scanner sc = new Scanner(System.in);
    private int rowIndex = 0, columnIndex = 0, number = 0;

    void runner() {
        processor.process();
        puzzlesToSolve = processor.getPuzzles();
        move();
    }

    void move() {
        System.out.println("Please chose row index:");
        rowIndex = sc.nextInt();
        System.out.println("Please chose column index:");
        columnIndex = sc.nextInt();
        System.out.println("Please chose number:");
        number = sc.nextInt();

        puzzlesToSolve[rowIndex][columnIndex] = number;

        System.out.println("Sudoku after your move:");
        printer(puzzlesToSolve);
    }

    void printer(int[][] currentBoard) {
        dispalyer(currentBoard);
    }

    static void dispalyer(int[][] currentBoard) {
        SudokuBoardMixer.showMixedGrid(currentBoard);
    }


}
