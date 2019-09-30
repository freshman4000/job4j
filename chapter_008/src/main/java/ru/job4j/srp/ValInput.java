package ru.job4j.srp;

public interface ValInput {
    boolean valAction(CalcUI actions, String action);
    boolean valValues(String values);
    boolean valMethodName(String value);
}
