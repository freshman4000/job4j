package ru.job4j.srp.srpcalculator.messages;

import ru.job4j.srp.srpcalculator.interfaces.Message;
import ru.job4j.srp.srpcalculator.userinterfaces.InterCalcUI;

/**
 * This class prints menu lines.
 */
public class MenuMessage implements Message {

    @Override
    public void execute() {
        for (String menuLines : new InterCalcUI().getLines()) {
            System.out.println(menuLines);
        }
    }
}
