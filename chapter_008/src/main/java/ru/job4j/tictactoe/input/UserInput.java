package ru.job4j.tictactoe.input;

import ru.job4j.tictactoe.logic.FreeCellsLogic;

import java.util.Map;

/**
 * This class gets complex input from user.
 */
public class UserInput implements Input<Integer> {
    private Input<String> input;
    private String[][] dots;

    public UserInput(Input<String> input, String[][] dots) {
        this.input = input;
        this.dots = dots;
    }

    /**
     * This method guides user through questions, till it gets keyboard input from user.
     * If inputted value is not a number or out of range, this method will throw exception,
     * messaging about error and return null value.
     *
     * @return null or in range number.
     */
    @Override
    public Integer getInput() {
        Map<Integer, int[]> freeCells = new FreeCellsLogic(dots).executeLogic();
        System.out.println("Make choice of the cell!");
        for (Map.Entry<Integer, int[]> pair : freeCells.entrySet()) {
            System.out.println(String.format("Choose %d for cell [%d, %d]", pair.getKey(), pair.getValue()[0], pair.getValue()[1]));
        }
        Integer choice = null;
        try {
            choice = Integer.parseInt(input.getInput());
            if (!freeCells.containsKey(choice)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error! No such cell! Choose existing cell!");
        }
        return choice;
    }
}