package com.ventumdei;

public class Sudoku {

    public static void main(String[] args) {
//        SudokuBoardMixer sbm = new SudokuBoardMixer();
//
//        sbm.shuffle();

    GamePreparator preparator = new GamePreparator();

    preparator.boardPreparator(Difficulty.HARD);
    preparator.BoardDisplay(preparator.getBoardToBeSolved());

    }
}
