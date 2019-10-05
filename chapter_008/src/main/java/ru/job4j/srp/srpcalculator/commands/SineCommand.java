package ru.job4j.srp.srpcalculator.commands;

import ru.job4j.srp.srpcalculator.interfaces.Command;
import ru.job4j.srp.srpcalculator.logs.State;

public class SineCommand implements Command {
    private double[] args;

    public SineCommand(double[] args) {
        this.args = args;
    }

/**
 * This method calculates sine of an angle.
 * One argument should be passed: value of an angle.
 **/

    @Override
    public void executeCommand() {
        double result = Math.sin(args[0]);
        State.setCurrentValue(result);
        System.out.println(result);
    }
}
