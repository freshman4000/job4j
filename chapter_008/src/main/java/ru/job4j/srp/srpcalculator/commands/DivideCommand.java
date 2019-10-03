package ru.job4j.srp.srpcalculator.commands;

import ru.job4j.srp.srpcalculator.interfaces.Command;
import ru.job4j.srp.srpcalculator.logs.State;

public class DivideCommand implements Command {
    private double[] args;

    public DivideCommand(double[] args) {
        this.args = args;
    }

    /**
     * This method divides consecutively all arguments.
     *
     * @return result of division.
     */
    @Override
    public void executeCommand() {
        double result = args[0];
        for (int i = 1; i < args.length; i++) {
            result /= args[i];
        }
        State.setCurrentValue(result);
        State.setReuseOn(true);
        System.out.println(result);
    }
}

