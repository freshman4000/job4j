package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, List range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (Object value : range) {
            if ((Integer) value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutOfBoundsException("Input number is out of menu range. Type number from 0 to " + (range.size() - 1));
        }
        return key;
    }
}

