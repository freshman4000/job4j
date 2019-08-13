package ru.job4j.chess.firuges;

public class OcupiedWayException extends Exception {
    public String getMessage() {
        String message = "Occupied way!";
        return message;
    }
}
