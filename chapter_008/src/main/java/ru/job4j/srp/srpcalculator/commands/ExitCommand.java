package ru.job4j.srp.srpcalculator.commands;

import ru.job4j.srp.srpcalculator.interfaces.Command;

/**
 * This class exits application if it was users choice.
 */
public class ExitCommand implements Command {

    @Override
    public void executeCommand() {
        System.exit(0);
    }
}
