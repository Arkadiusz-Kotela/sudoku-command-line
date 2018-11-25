package com.ventumdei;

import java.util.Random;

import static com.ventumdei.BoardConstants.EMPTY_BOARD;
import static com.ventumdei.BoardConstants.SIZE;

class GamePreparator {
    private Solver solver = new Solver(EMPTY_BOARD);
    private Random random = new Random();


    private int[][] boardToBeSolved;


    int[][] boardPreparator(Difficulty difficulty) {
        solver.solveBoard();
        boardToBeSolved = solver.getBoard();
        int numberOfCells = 0;

        while (numberOfCells < difficulty.getNumVal()) {
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);
            if (boardToBeSolved[x][y] != 0) {
                boardToBeSolved[x][y] = 0;
                numberOfCells++;
            }
        }
        return boardToBeSolved;
    }

    void BoardDisplay(int[][] boardToBeSolved) {
        for (int i = 0; i < SIZE; ++i) {
            if (i % 3 == 0) {
                System.out.println(" ");
            }
            for (int j = 0; j < SIZE; ++j) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(boardToBeSolved[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
