package ru.job4j.chess.firuges;

public class ImposibleMoveException extends Exception {
    public String getMessage() {
        String message = "Can't move like this";
        return message;
    }
}

