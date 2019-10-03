package ru.job4j.srp.srpcalculator.messageprinters;

import ru.job4j.srp.srpcalculator.interfaces.Message;
import ru.job4j.srp.srpcalculator.interfaces.MessagePrinter;

/**
 * This class is responsible for printing messages.
 */
public class ICMessagePrinter implements MessagePrinter {
    @Override
    public void printMessage(Message message) {
        message.execute();
    }
}
