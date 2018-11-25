package com.ventumdei;

public enum Difficulty {
    EASY(25),
    MEDIUM(30),
    HARD(35);

    private int numVal;

    Difficulty(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
