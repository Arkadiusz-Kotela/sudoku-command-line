package com.ventumdei;

import java.util.Scanner;

import static com.ventumdei.BoardConstants.SIZE;

public class SudokuProcessor {
    private GamePreparator preparator = new GamePreparator();
    private int[][] puzzles = new int[SIZE][SIZE];
    private Scanner scanner = new Scanner(System.in);

    void process() {
        System.out.println("Welcome to the Sudoku game.");
        System.out.println("Please choose difficulty level: ");
        System.out.println("1 - EASY");
        System.out.println("2 - MEDIUM");
        System.out.println("3 - HARD");

        int level = scanner.nextInt();

        switch (level) {
            case 1:
                System.out.println("You have chosen level EASY: ");
                puzzles = preparator.boardPreparator(Difficulty.EASY);
                preparator.BoardDisplay(puzzles);
                break;
            case 2:
                System.out.println("You have chosen level MEDIUM: ");
                puzzles = preparator.boardPreparator(Difficulty.MEDIUM);
                preparator.BoardDisplay(puzzles);
                break;
            case 3:
                System.out.println("You have chosen level HARD: ");
                puzzles = preparator.boardPreparator(Difficulty.HARD);
                preparator.BoardDisplay(puzzles);
                break;
        }
    }

    public int[][] getPuzzles() {
        return puzzles;
    }
}
