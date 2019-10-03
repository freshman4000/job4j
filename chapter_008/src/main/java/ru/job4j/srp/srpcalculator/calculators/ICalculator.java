package ru.job4j.srp.srpcalculator.calculators;

import ru.job4j.srp.srpcalculator.interfaces.Calculator;
import ru.job4j.srp.srpcalculator.interfaces.Command;

/**
 * This class creates calculator, which can execute commands.
 */
public class ICalculator implements Calculator {
    @Override
    public void doAction(Command command) {
        command.executeCommand();
    }
}
