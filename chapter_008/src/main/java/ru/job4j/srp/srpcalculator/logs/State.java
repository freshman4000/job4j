package ru.job4j.srp.srpcalculator.logs;

import ru.job4j.srp.srpcalculator.abstractclasses.Log;

/**
 * This class keeps info on state of previous answer and its value.
 */
public class State extends Log {

    private static double currentValue;

    private static boolean reuseOn = false;

    public static boolean isReuseOn() {
        return reuseOn;
    }

    public static void setReuseOn(boolean reuseOn) {
        State.reuseOn = reuseOn;
    }

    public static double getCurrentValue() {
        return currentValue;
    }

    public static void setCurrentValue(double currentValue) {
        State.currentValue = currentValue;
    }
}
