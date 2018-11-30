package com.ventumdei;

import static com.ventumdei.BoardConstants.EMPTY_BOARD;
import static com.ventumdei.BoardConstants.SIZE;

class SudokuBoardMixer {
    private Solver solver = new Solver(EMPTY_BOARD);
    private int[][] finalGrid = new int[SIZE][SIZE];

    int[][] getFinalGrid() {
        return finalGrid;
    }

    int[][] shuffle() {
        int[][] mixedBoard;
        solver.solveBoard();
        mixedBoard = solver.getBoard();

        //Swapping to rows in the same group - indexes 0-2, 3-5, 6-8
        for (int i = 0; i < SIZE / 3; ++i) {
            for (int j = 0; j < 9; j += 3) {
                int temp = mixedBoard[2][i+j];
                mixedBoard[2][i+j] = mixedBoard[0][i+j];
                mixedBoard[0][i+j] = temp;
            }
        }
        //Temporary checker if swapped column are fine with sudoku rules
        Solver temp1 = new Solver(mixedBoard);
        temp1.solveBoard();

        //Swapping to columns in the same group - indexes 0-2, 3-5, 6-8
        for (int i = 0; i < SIZE / 3; ++i) {
            for (int j = 0; j < 9; j += 3) {
                int temp = mixedBoard[i+j][0];
                mixedBoard[i+j][0] = mixedBoard[i+j][2];
                mixedBoard[i+j][2] = temp;
            }
        }
        //Temporary checker if swapped column are fine with sudoku rules
        Solver temp2 = new Solver(mixedBoard);
        temp2.solveBoard();

        //Transposing whole grid
        for (int i = 0; i < SIZE / 3; ++i) {
            for (int j = 0; j < 9; j += 3) {
                finalGrid[i][j] = mixedBoard[j][i];
            }
        }

        //Temporary checker if swapped column are fine with sudoku rules
        Solver temp3 = new Solver(finalGrid);
        temp3.solveBoard();

        return finalGrid;
    }

}

