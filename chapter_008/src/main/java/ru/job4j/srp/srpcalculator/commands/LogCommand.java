package ru.job4j.srp.srpcalculator.commands;

import ru.job4j.srp.srpcalculator.interfaces.Command;
import ru.job4j.srp.srpcalculator.logs.State;

public class LogCommand implements Command {
    private double[] args;

    public LogCommand(double[] args) {
        this.args = args;
    }

    /**
     * This method calculates log10 of a number.
     * One argument should be passed: value of number.
     **/

    @Override
    public void executeCommand() {
        double result = Math.log10(args[0]);
        State.setCurrentValue(result);
        System.out.println(result);
    }
}
