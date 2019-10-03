package ru.job4j.srp.srpcalculator.interfaces;

public interface Validation<T> {
    boolean validate(T input);
}
