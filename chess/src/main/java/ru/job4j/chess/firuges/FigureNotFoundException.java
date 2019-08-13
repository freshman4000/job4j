package ru.job4j.chess.firuges;

public class FigureNotFoundException extends Exception {
    public String getMessage() {
        String message = "Figure not found";
        return message;
    }
}
