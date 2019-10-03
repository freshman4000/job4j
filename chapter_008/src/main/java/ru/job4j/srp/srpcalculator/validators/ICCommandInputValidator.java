package ru.job4j.srp.srpcalculator.validators;

import ru.job4j.srp.srpcalculator.interfaces.Validation;
import ru.job4j.srp.srpcalculator.userinterfaces.InterCalcUI;

/**
 * This class validates if command exists in current UI list.
 */
public class ICCommandInputValidator implements Validation<String> {

    @Override
    public boolean validate(String input) {
        boolean result = false;
        for (String command : new InterCalcUI().getLines()) {
            if (command.split(" ")[0].equals(input)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
