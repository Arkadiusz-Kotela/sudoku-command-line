package com.ventumdei;

import java.util.Scanner;

public class Validator {

    Scanner sc = new Scanner(System.in);

    public void validateNumber() {
        System.out.println("Enter number between 1 - 9");
        int number = sc.nextInt();
        while (number >= 1 && number <= 9) {
            System.out.println("Wrong number. Enter 1 - 9");
            number = sc.nextInt();
        }
    }
}
