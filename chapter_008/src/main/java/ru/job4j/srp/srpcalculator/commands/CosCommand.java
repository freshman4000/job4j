package ru.job4j.srp.srpcalculator.commands;

import ru.job4j.srp.srpcalculator.interfaces.Command;
import ru.job4j.srp.srpcalculator.logs.State;

public class CosCommand implements Command {
    private double[] args;

    public CosCommand(double[] args) {
        this.args = args;
    }

    /**
     * This method calculates cosine of an angle.
     * One argument should be passed: value of an angle.
     **/

    @Override
    public void executeCommand() {
        double result = Math.cos(args[0]);
        State.setCurrentValue(result);
        System.out.println(result);
    }
}