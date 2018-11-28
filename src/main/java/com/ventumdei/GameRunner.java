package com.ventumdei;

import java.util.Scanner;

import static com.ventumdei.BoardConstants.SIZE;

public class GameRunner {
    private SudokuProcessor processor = new SudokuProcessor();
    private static int[][] puzzlesToSolve;
    private Scanner sc = new Scanner(System.in);
    private int rowIndex = 0, columnIndex = 0, number = 0;

    public static int[][] getPuzzlesToSolve() {
        return puzzlesToSolve;
    }

    boolean runGame() {
        processor.process();
        puzzlesToSolve = processor.getPuzzles();
        BoardPrinter.showBoard(puzzlesToSolve);

        if (move()) {
            System.out.println();
            System.out.println("You have completed the board");
            return true;
        }
        return false;
    }

    boolean move() {
        do {
            questions();

            while (checkIfCellOccupied(rowIndex, columnIndex, puzzlesToSolve)) {
                System.out.println("The cell of given indexes: [" + rowIndex + "][" + columnIndex + "] is occupied");
                questions();
            }

            System.out.print("Please chose number in cell of given indexes: [" + rowIndex + "][" + columnIndex + "]: ");
            number = enteredValueChecker();

            System.out.println("Sudoku after your move:");
            puzzlesToSolve[rowIndex][columnIndex] = number;

            BoardPrinter.showBoard(puzzlesToSolve);

        } while (!checkEmpties(puzzlesToSolve));

        return true;
    }


    private void questions() {
        System.out.println();
        System.out.print("Please chose row index: ");
        rowIndex = enteredValueChecker();
        System.out.print("Please chose column index: ");
        columnIndex = enteredValueChecker();

    }

    private int enteredValueChecker() {
        boolean end = false;
        int value = 0;
        do {
            if (!sc.hasNextInt()) {
                System.out.print("Non numeric value. An integer please: ");
                sc.next();
            } else {
                value = sc.nextInt();
                end = true;
            }
        } while (!end);
        return value;
    }

    private boolean checkIfCellOccupied(int row, int column, int[][] board) {
        return board[row][column] != 0;
    }


    private boolean checkEmpties(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }

}
