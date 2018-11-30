package com.ventumdei;

class Validator {
    private static int[][] board;

    void check() {
        board = GameRunner.getPuzzlesToSolve();

        if (rowChecker() && columnChecker() && boxChecker()) {
            System.out.println();
            System.out.println("Solution correct");
        } else {
            System.out.println();
            System.out.println("Solution incorrect");
        }
    }

    private boolean rowChecker() {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 8; ++col) {
                for (int col2 = col + 1; col2 < 9; ++col2) {
                    if (board[row][col] == board[row][col2]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean columnChecker() {
        for (int col = 0; col < 9; ++col) {
            for (int row = 0; row < 8; ++row) {
                for (int row2 = row + 1; row2 < 9; ++row2) {
                    if (board[row][col] == board[row2][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean boxChecker() {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                // row, col is start of the 3 by 3 grid
                for (int pos = 0; pos < 8; ++pos) {
                    for (int pos2 = pos + 1; pos2 < 9; ++pos2) {
                        if (board[row + pos % 3][col + pos / 3] == board[row + pos2 % 3][col + pos2 / 3]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
