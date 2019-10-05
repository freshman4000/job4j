package ru.job4j.srp.srpcalculator.userinterfaces;

import ru.job4j.srp.srpcalculator.interfaces.UI;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that is responsible for UI appearance.
 */
public class InterCalcUI implements UI {
    /**
     * This variable represents list of lines in UI.
     */
    private List<String> lines;

    public InterCalcUI(List<String> lines) {
        this.lines = lines;
    }

    public InterCalcUI() {
        this.lines = new LinkedList<>();
        initUI();

    }

    public List<String> getLines() {
        return lines;
    }

    /**
     * This method initializes UI with chosen values.
     */
    @Override
    public void initUI() {
        lines.add("0 Clear: ");
        lines.add("1 Add: ");
        lines.add("2 Subtract: ");
        lines.add("3 Multiply: ");
        lines.add("4 Divide: ");
        lines.add("6 Sine: ");
        lines.add("7 Cosine: ");
        lines.add("8 Power: ");
        lines.add("9 Log10: ");
        lines.add("5 Exit: ");
    }
}
