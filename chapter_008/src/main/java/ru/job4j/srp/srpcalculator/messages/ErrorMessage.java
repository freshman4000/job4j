package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;

/**
 * This class prints message which informs, that something is wrong with current input.
 */
public class ErrorMessage implements Message {

    @Override
    public void execute() {
        System.out.println("\"Wrong input. Check if values are numbers, separated by single whitespace and using \"dot\" as floating point separator.");
    }
}
