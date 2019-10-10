package ru.job4j.tictactoe.players;

import ru.job4j.tictactoe.input.Input;

/**
 * Class that represents player in ticTacToe.
 */
public class TicTacToePlayer implements Player {
    private Input<Integer> input;
    private String sign;

    public TicTacToePlayer(Input<Integer> input, String sign) {
        this.input = input;
        this.sign = sign;
    }

    /**
     *THis method gets players choice from players input.
     * @return integer number.
     */
    @Override
    public int makeChoice() {
        Integer result = input.getInput();
        return result == null ? -1 : result;
    }

    /**
     * This method gets assigned to player sign value.
     * @return String value of sign.
     */
    @Override
    public String getSign() {
        return sign;
    }
}