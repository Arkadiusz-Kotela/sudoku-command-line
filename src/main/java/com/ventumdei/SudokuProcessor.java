package com.ventumdei;

import java.util.Scanner;

public class SudokuProcessor {
    private GamePreparator preparator = new GamePreparator();
    private Validator validator;

    private Scanner scanner = new Scanner(System.in);

    void process() {
        System.out.println("Welcome to the Sudoku game.");
        System.out.println("Please choose difficulty level: ");
        System.out.println("1 - EASY");
        System.out.println("2 - MEDIUM");
        System.out.println("3 - HARD");

        int level = scanner.nextInt();


    }
}
