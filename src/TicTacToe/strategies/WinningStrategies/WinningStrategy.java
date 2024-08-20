package TicTacToe.strategies.WinningStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Move move, Board board);
}
