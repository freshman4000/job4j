package ru.job4j.tracker;

import java.util.List;

/**
 * Interface for data input.
 */
public interface Input {
    String ask(String question);
    int ask(String question, List<Integer> range);
}
