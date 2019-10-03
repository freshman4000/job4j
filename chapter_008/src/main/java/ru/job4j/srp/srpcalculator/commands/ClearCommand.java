package ru.job4j.srp.srpcalculator.commands;

import ru.job4j.srp.srpcalculator.interfaces.Command;
import ru.job4j.srp.srpcalculator.logs.State;

/**
 * This class clears previous answer state.
 */
public class ClearCommand implements Command {
    @Override
    public void executeCommand() {
        State.setReuseOn(false);
    }
}
