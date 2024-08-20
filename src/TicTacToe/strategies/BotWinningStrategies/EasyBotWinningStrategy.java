package TicTacToe.strategies.BotWinningStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.CellState;
import TicTacToe.models.Move;

import java.awt.*;
import java.util.List;

public class EasyBotWinningStrategy implements BotWinningStrategy {

    @Override
    public Move makeMove(Board board) {
        for(List<Cell> cells : board.getBoard()){
            for(Cell cell : cells){
                if(cell.getCellState()== CellState.EMPTY){
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
