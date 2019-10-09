package ru.job4j.tdd;

public class KeyDiffException extends Exception {
    private String message;

    public KeyDiffException(String message) {
        this.message = message;
    }
}
