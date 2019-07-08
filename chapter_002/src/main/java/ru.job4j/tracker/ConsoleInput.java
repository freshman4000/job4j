package ru.job4j.tracker;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
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
    public int ask(String question, int range) {
        int result = Integer.valueOf(this.ask(question));
        if (result < 0 || result > range - 1) {
            throw new MenuOutOfBoundsException("Input number is out of menu range. Type number from 0 to " + (range - 1));
        }
            return result;
    }
}
