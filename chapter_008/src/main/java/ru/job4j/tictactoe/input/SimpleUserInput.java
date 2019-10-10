package ru.job4j.tictactoe.input;

import java.util.Scanner;

/**
 * This class is  responsible for user keyboard input.
 */
public class SimpleUserInput implements Input<String> {
    /**
     * Gets input from users keyboard.
     *
     * @return String value of input.
     */
    @Override
    public String getInput() {
        return new Scanner(System.in).nextLine();
    }
}
