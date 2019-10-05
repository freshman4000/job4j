package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;

public class WrongInputMessage implements Message {
    @Override
    public void execute() {
        System.out.println("Wrong input! Try one more time!");
    }
}
