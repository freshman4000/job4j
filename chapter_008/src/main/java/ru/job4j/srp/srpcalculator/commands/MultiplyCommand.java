package ru.job4j.srp.srpcalculator.commands;

import ru.job4j.srp.srpcalculator.interfaces.Command;
import ru.job4j.srp.srpcalculator.logs.State;

import java.util.Arrays;

public class MultiplyCommand implements Command {
    private double[] args;

    public MultiplyCommand(double[] args) {
        this.args = args;
    }

    /**
     * This method multiplies consecutively all arguments.
     *
     * @return result of multiplication.
     */
    @Override
    public void executeCommand() {
        double result = Arrays.stream(args).reduce(1, (x, y) -> x * y);
        State.setCurrentValue(result);
        State.setReuseOn(true);
        System.out.println(result);
    }
}
