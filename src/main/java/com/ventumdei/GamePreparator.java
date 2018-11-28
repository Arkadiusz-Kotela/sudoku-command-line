package com.ventumdei;

import java.util.Random;

import static com.ventumdei.BoardConstants.SIZE;

class GamePreparator {
    //    private Solver solver = new Solver(EMPTY_BOARD);
    private Random random = new Random();
    private SudokuBoardMixer mixer = new SudokuBoardMixer();


    private int[][] boardToBeSolved;


    int[][] boardPreparator(Difficulty difficulty) {
        mixer.shuffle();

        System.out.println("=======================");

        //Getting final grid to be strike out as per difficulty level
        boardToBeSolved = mixer.getFinalGrid();

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

    public int[][] getBoardToBeSolved() {
        return boardToBeSolved;
    }
}
