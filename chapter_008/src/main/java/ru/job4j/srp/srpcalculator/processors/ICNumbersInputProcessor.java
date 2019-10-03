package ru.job4j.srp.srpcalculator.processors;

import ru.job4j.srp.srpcalculator.interfaces.Input;
import ru.job4j.srp.srpcalculator.interfaces.Processor;
import ru.job4j.srp.srpcalculator.logs.State;

import java.util.Arrays;

/**
 * This class is responsible for preparation and transformation of input, to
 * double numbers, ready for culculation.
 */
public class ICNumbersInputProcessor implements Processor<double[]> {
    private Input input;

    public ICNumbersInputProcessor(Input input) {
        this.input = input;
    }

    /**
     * This method takes input, checks if previous answer exists and needs to be used. If so - it adds
     * previous answer to array of doubles and returns it. If not - just returns parsed values from passed
     * string input.
     *
     * @return array of numbers.
     */
    @Override
    public double[] process() {
        String value = State.isReuseOn() ? String.valueOf(State.getCurrentValue()).concat(" ").concat(input.passInput())
                : input.passInput();
        return Arrays.stream(value.split(" ")).mapToDouble(Double::parseDouble).toArray();
    }
}
