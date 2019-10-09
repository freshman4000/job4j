package ru.job4j.tdd;

public interface Generator<T> {
    T generate() throws Exception;
}
