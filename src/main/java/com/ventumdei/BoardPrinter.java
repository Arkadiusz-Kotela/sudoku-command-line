package com.ventumdei;

import static com.ventumdei.BoardConstants.SIZE;

public class BoardPrinter {

    public static void showBoard(int[][] board) {
        for (int i = 0; i < SIZE; ++i) {
            if (i % 3 == 0) {
                System.out.println(" ");
            }
            for (int j = 0; j < SIZE; ++j) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
}
