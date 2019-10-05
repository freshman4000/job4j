package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;

public class OneNumberAppealMessage implements Message {
    @Override
    public void execute() {
        System.out.println("Type just one number or clear the current result, to input two numbers");
    }
}
