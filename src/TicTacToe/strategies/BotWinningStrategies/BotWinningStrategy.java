package TicTacToe.strategies.BotWinningStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface BotWinningStrategy {
   public Move makeMove(Board board);
}
