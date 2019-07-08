package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int range) {
    int result = -1;
    boolean normalInput = false;
        do {
            try {
                result = super.ask(question, range);
                normalInput = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Input should be a number, not a text");
            } catch (MenuOutOfBoundsException mobe) {
                System.out.println("Input should be a number between 0 and " + (range - 1));
            }
           } while (!normalInput);
        return result;
    }
}
