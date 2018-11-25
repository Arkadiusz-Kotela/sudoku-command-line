package com.ventumdei;

public class Sudoku {

    public static void main(String[] args) {
        GamePreparator preparator = new GamePreparator();


        preparator.BoardDisplay(preparator.boardPreparator(Difficulty.HARD));
    }
}
