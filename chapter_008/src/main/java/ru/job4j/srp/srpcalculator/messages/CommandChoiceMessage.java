package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;

/**
 * This class prints message with appeal to choose command.
 */
public class CommandChoiceMessage implements Message {
    @Override
    public void execute() {
        System.out.println("Choose command.");
    }
}
