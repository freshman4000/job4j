package ru.job4j.srp.srpcalculator.inputs;

import ru.job4j.srp.srpcalculator.interfaces.Input;

/**
 * This class represents input of string values for testing purposes.
 */
public class TestInput implements Input {
    private String[] input;
    private int position = 0;

    public TestInput(String[] input) {
        this.input = input;
    }

    @Override
    public String passInput() {
        return input[position++];
    }
}
