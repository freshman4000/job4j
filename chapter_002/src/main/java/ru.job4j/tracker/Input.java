package ru.job4j.tracker;
/**
 * Interface for data input.
 */
public interface Input {
    String ask(String question);
    int ask(String question, int range);
}
