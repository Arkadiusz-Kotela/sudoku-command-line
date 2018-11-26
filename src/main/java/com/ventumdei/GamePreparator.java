package com.ventumdei;

import java.util.Random;

import static com.ventumdei.BoardConstants.SIZE;

class GamePreparator {
    //    private Solver solver = new Solver(EMPTY_BOARD);
    private Random random = new Random();
    private SudokuBoardMixer mixer = new SudokuBoardMixer();


    private int[][] boardToBeSolved;


    int[][] boardPreparator(Difficulty difficulty) {
        /*
        TODO replace with outcome sudoku board from SudokuBoardMixer
        solver.solveBoard();
        boardToBeSolved = solver.getBoard();
        */

        mixer.shuffle();

        //Test printing
        mixer.showGrid();
        System.out.println("==========================");


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

    void BoardDisplay(int[][] boardToBeSolved) {
        GameRunner.dispalyer(boardToBeSolved);
    }

    public int[][] getBoardToBeSolved() {
        return boardToBeSolved;
    }
}
