package com.ventumdei;

public enum Difficulty {
    EASY(28),
    MEDIUM(37),
    HARD(46);

    private int numVal;

    Difficulty(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
