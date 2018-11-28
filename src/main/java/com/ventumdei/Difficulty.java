package com.ventumdei;

public enum Difficulty {
    EASY(1),
    MEDIUM(55),
    HARD(60);

    private int numVal;

    Difficulty(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
