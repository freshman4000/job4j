package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;

/**
 * This class prints message with appeal to input one ore more numbers.
 */
public class SuggestInputNumMessage implements Message {
    @Override
    public void execute() {
        System.out.println("Input one number or numbers separated by single whitespace!");
    }
}
