package ru.job4j.tracker;

import java.util.Scanner;
/**
 * class ConsoleInput that handles users input.
 */
public class ConsoleInput implements Input {
    @Override
    public String ask(String question) {
        System.out.println(question);
    Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
