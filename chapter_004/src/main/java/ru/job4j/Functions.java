package ru.job4j;

import java.util.List;
import java.util.function.Function;

/**
 * Functional:) interface.
 */
public interface Functions {
    List<Double> diapason(int start, int end, Function<Double, Double> func);
}

