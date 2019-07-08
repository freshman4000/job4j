package ru.job4j.tracker;

public class MenuOutOfBoundsException extends RuntimeException {
   String message;
    public MenuOutOfBoundsException(String message) {
       this.message = message;
   }
}
