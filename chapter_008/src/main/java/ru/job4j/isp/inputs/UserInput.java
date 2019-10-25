package ru.job4j.isp.inputs;

import java.util.Scanner;

/**
 * This is particular class, that gets input from the keyboard
 * of the user.
 */
public class UserInput implements Input {
    @Override
    public String getInput() {
        return new Scanner(System.in).nextLine();
    }
}