package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;

/**
 * This class prints separation line.
 */
public class SeparatorMessage implements Message {
    @Override
    public void execute() {
        System.out.println("================");
    }
}
