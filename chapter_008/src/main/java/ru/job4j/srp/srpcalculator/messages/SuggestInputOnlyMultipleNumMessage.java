package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;

/**
 * This class prints message with appeal to input only several numbers. One number is not allowed.
 */
public class SuggestInputOnlyMultipleNumMessage implements Message {
    @Override
    public void execute() {
        System.out.println("Input several numbers, separated by single whitespace!");
    }
}
