package ru.job4j.tictactoe.input;

import ru.job4j.tictactoe.logic.FreeCellsLogic;

import java.util.Random;

/**
 * Class that is responsible for non-human player input.
 */
public class AIInput implements Input<Integer> {
    private String[][] dots;

    public AIInput(String[][] dots) {
        this.dots = dots;
    }

    /**
     * This method gets freeCells and randomly chooses among them.
     *
     * @return number of needed cell.
     */
    @Override
    public Integer getInput() {
        Random rnd = new Random(System.currentTimeMillis());
        return rnd.nextInt(new FreeCellsLogic(dots).executeLogic().size());
    }
}
