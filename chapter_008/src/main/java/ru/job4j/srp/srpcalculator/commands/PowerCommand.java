package ru.job4j.srp.srpcalculator.commands;

import ru.job4j.srp.srpcalculator.interfaces.Command;
import ru.job4j.srp.srpcalculator.logs.State;

public class PowerCommand implements Command {
    private double[] args;

    public PowerCommand(double[] args) {
        this.args = args;
    }

    /**
     * This method powers first passed argument (number) by power of second argument (number). If current result exists
     * - only one argument should be passed. If it doesn't - two arguments should be passed: first - number to power,
     * and the second - is actual power.
     */

    @Override
    public void executeCommand() {
        double result = Math.pow(args[0], args[1]);
        State.setCurrentValue(result);
        State.setReuseOn(true);
        System.out.println(result);
    }
}

