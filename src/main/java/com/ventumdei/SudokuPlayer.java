package com.ventumdei;

import java.util.Scanner;

public class SudokuPlayer {
    private GameRunner runner = new GameRunner();
    private Validator validator = new Validator();
    private Scanner sc = new Scanner(System.in);
    private boolean end = false;

    public void run() {
        do {
            runner.runGame();
            validator.check();
            System.out.println("Do you want to play again (y/n): ");
            if (sc.next().equalsIgnoreCase("n")) {
                end = true;
            }
        } while (!end);
    }
}
