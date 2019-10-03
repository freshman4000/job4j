package ru.job4j.srp.srpcalculator.commands;

import ru.job4j.srp.srpcalculator.interfaces.Command;
import ru.job4j.srp.srpcalculator.logs.State;

import java.util.Arrays;

public class AddCommand implements Command {
    private double[] args;

    public AddCommand(double[] args) {
        this.args = args;
    }

    /**
     * This method adds consecutively all arguments.
     *
     * @return result of addition.
     */
    @Override
    public void executeCommand() {
        double result = Arrays.stream(args).sum();
        State.setCurrentValue(result);
        State.setReuseOn(true);
        System.out.println(result);
    }
}
