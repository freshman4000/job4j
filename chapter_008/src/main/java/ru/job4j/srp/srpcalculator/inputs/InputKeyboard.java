package ru.job4j.srp.srpcalculator.inputs;

import ru.job4j.srp.srpcalculator.interfaces.Input;

import java.util.Scanner;

/**
 * This class represents keyboard user input.
 */
public class InputKeyboard implements Input {
    Scanner sc;

    public InputKeyboard() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public String passInput() {
        return sc.nextLine();
    }
}
