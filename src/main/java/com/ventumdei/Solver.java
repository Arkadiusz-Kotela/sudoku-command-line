package com.ventumdei;

import static com.ventumdei.BoardConstants.*;

class Solver {

    private int[][] board;

    Solver(int[][] board) {
        this.board = board;
    }

    int[][] getBoard() {
        return board;
    }

    void solveBoard() {
        if (solve(0, 0)) {
            //TODO implement method considering two cases
            System.out.println("====Your Sudoku board====");
        } else {
            System.out.println("No solution");
        }
    }

    private void printSolution() {
        System.out.println("Nice");
    }


    boolean solve(int rowIndex, int columnIndex) {
        if (rowIndex == SIZE && ++columnIndex == SIZE) return true;

        if (rowIndex == SIZE) {
            rowIndex = 0;
        }

        if (board[rowIndex][columnIndex] != 0) {
            return solve(rowIndex + 1, columnIndex);
        }

        for (int number = MIN_CELL_VAL; number <= MAX_CELL_VAL; number++) {
            if (valid(rowIndex, columnIndex, number)) {
                board[rowIndex][columnIndex] = number;

                if (solve(rowIndex + 1, columnIndex)) {
                    return true;
                }

                //BACKTRACK
                board[rowIndex][columnIndex] = 0;
            }
        }
        return false;
    }

    private boolean valid(int rowIndex, int columnIndex, int actualNumber) {
        for (int i = 0; i < SIZE; ++i) {
            if (board[i][columnIndex] == actualNumber) {
                return false;
            }
        }

        for (int k = 0; k < SIZE; ++k) {
            if (board[rowIndex][k] == actualNumber) {
                return false;
            }
        }

        int boxRowOffset = (rowIndex / 3) * BOX_SIZE;
        int boxColumnOffset = (columnIndex / 3) * BOX_SIZE;

        for (int i = 0; i < BOX_SIZE; ++i) {
            for (int j = 0; j < BOX_SIZE; ++j) {
                if (actualNumber == board[boxRowOffset + i][boxColumnOffset + j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
