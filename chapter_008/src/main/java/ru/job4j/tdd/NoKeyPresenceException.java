package ru.job4j.tdd;

public class NoKeyPresenceException extends Exception {
    private String message;

    public NoKeyPresenceException(String message) {
        this.message = message;
    }
}
