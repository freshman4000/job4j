package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;

public class TwoNumAppealMessage implements Message {
    @Override
    public void execute() {
        System.out.println("Type exactly two numbers in order to make this calculation");
    }
}
