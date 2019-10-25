package ru.job4j.services.starterservice;

import java.io.FileNotFoundException;

/**
 * Interface, responsible for starting services
 * with/ or without incoming arguments.
 * @param <T> output type parameter.
 */
public interface StarterService<T> {
    void start() throws FileNotFoundException;
    void start(T item) throws FileNotFoundException;
}
