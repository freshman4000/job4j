package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;

/**
 * This class prints message which informs that command with such number is not in list.
 */
public class NoSuchCommandMessage implements Message {
    @Override
    public void execute() {
        System.out.println("No such command. Try one more time!");
    }
}
