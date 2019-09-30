package ru.job4j.srp;

public interface Calculator {
    double add(double[] args);
    double subtract(double[] args);
    double multiply(double[] args);
    double divide(double[] args) throws Exception;
    void clear();
}
