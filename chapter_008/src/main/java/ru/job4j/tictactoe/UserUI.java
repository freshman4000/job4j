package ru.job4j.tictactoe;

import ru.job4j.tictactoe.input.AIInput;
import ru.job4j.tictactoe.input.Input;
import ru.job4j.tictactoe.input.SimpleUserInput;
import ru.job4j.tictactoe.input.UserInput;
import ru.job4j.tictactoe.logic.FreeCellsLogic;
import ru.job4j.tictactoe.logic.Logic;
import ru.job4j.tictactoe.logic.WinnerLogic;
import ru.job4j.tictactoe.players.Player;
import ru.job4j.tictactoe.players.TicTacToePlayer;
import ru.job4j.tictactoe.ui.UI;
import ru.job4j.tictactoe.utilities.StingToIntMatrixTransformer;

import java.util.Map;

/**
 * This class uses graphics to show game process to observers and if human players
 * eligible - communicates with them by asking to make input from the keyboard.
 */
public class UserUI implements UI {

    private Board board;
    private Player player1;
    private Player player2;
    private Input<String> turnInput;

    public UserUI(Board board, Player player1, Player player2, Input<String> turnInput) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.turnInput = turnInput;
    }

    /**
     * This method first asks user if he/she wants player1 to make first move. If input is not Y, second player starts.
     * Players input their values one by one, one after other until the end of the game. If no winner - this method will output
     * "DRAW", if first player won - then Player1 WINS!, if second - Player2 WINS.
     */
    @Override
    public void start() {
        Logic winnerLogic = new WinnerLogic(board.getDots(), new StingToIntMatrixTransformer(board.getDots()));
        System.out.println("If you want Player1 to make first move type \"Y\"");
        boolean player1Starts = turnInput.getInput().equals("Y");
        board.draw();
        while (winnerLogic.executeLogic().equals("N")) {
            Map<Integer, int[]> freeCells = new FreeCellsLogic(board.getDots()).executeLogic();
            Move move = new Move(board.getDots(), freeCells);
            if (player1Starts) {
                System.out.println("Player 1! Your turn!");
                move.execute(player1);
                board.draw();
                player1Starts = false;
            } else {
                System.out.println("Player 2! Your turn!");
                move.execute(player2);
                board.draw();
                player1Starts = true;
            }
        }
        System.out.println(winnerLogic.executeLogic().equals("N") || winnerLogic.executeLogic().equals("full") ? "DRAW!"
                : winnerLogic.executeLogic().equals(player1.getSign()) ? "PLAYER1 WINS!" : "PLAYER2 WINS!");
    }

    /**
     * App entrance point.
     * @param args args.
     */
    public static void main(String[] args) {
        Board board = new Board(3, " ");
        Player p1 = new TicTacToePlayer(new UserInput(new SimpleUserInput(), board.getDots()), "X");
        Player p2 = new TicTacToePlayer(new AIInput(board.getDots()), "O");
        new UserUI(board, p1, p2, new SimpleUserInput()).start();
    }
}
