package ru.job4j.tracker;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
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
    public int ask(String question, List range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (Object value : range) {
            if ((Integer)value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else throw new MenuOutOfBoundsException("Input number is out of menu range. Type number from 0 to " + (range.size() - 1));
    }
}
