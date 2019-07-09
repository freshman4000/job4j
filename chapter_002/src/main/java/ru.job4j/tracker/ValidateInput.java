package ru.job4j.tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    public int ask(String question, List range) {
        int result = -1;
        boolean normalInput = false;
        do {
            try {
                result = input.ask(question, range);
                normalInput = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Input should be a number, not a text");
            } catch (MenuOutOfBoundsException mobe) {
                System.out.println("Input should be a number between 0 and " + (range.size() - 1));
            }
        } while (!normalInput);
        return result;
    }
}
