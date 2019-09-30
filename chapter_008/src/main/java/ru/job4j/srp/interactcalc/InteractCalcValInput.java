package ru.job4j.srp.interactcalc;

import ru.job4j.srp.CalcUI;
import ru.job4j.srp.ValInput;

/**
 * This class methods are responsible for user inputs validation.
 */
public class InteractCalcValInput implements ValInput {
    /**
     * Method that validates if inputted value is in range of available methods.
     * @param actions currently used Calculator User Interface.
     * @param action inputted value - users choice of action.
     * @return boolean value - if input matches requirements.
     */
    @Override
    public boolean valAction(CalcUI actions, String action) {
    boolean result = false;
    try {
        if (actions.getActions().size() - 1 >= Integer.parseInt(action)) {
            result = true;
        }
    } catch (Exception e) {
        result = false;
    }
        return result;
    }

    /**
     * Method that validates inputted values by the rule: "all values should be numbers separated by single whitespace.
     * If numbers are with floating point, separator should be only and only "dot"".
     * @param values string of inputted values.
     * @return boolean value - if input matches requirements.
     */
    @Override
    public boolean valValues(String values) {
    return values.matches("(([\\d]+)(\\.)?([\\d]+)? )*?(([\\d]+)(\\.)?([\\d]+)?)$");
    }

    /**
     * This method checks if method name equals specific value.
     * @param value method name.
     * @return boolean value if method name equals specified value.
     */
    @Override
    public boolean valMethodName(String value) {
        return value.equals("clear");
    }
}
