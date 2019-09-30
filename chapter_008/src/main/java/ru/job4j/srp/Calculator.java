package ru.job4j.srp;

public interface Calculator {
    double add(double[] args);

    double subtract(double[] args);

    double multiply(double[] args);

    double divide(double[] args) throws Exception;

    void clear();

    double power(double[] args) throws Exception;

    double sine(double[] args) throws Exception;

    double cosine(double[] args) throws Exception;

    double log10(double[] args);
}
