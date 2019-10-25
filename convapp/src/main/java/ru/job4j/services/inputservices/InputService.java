package ru.job4j.services.inputservices;
/**
 * Interface, responsible for data input.
 * @param <T> output type parameter.
 */
public interface InputService<T> {
    T getInput();
}
