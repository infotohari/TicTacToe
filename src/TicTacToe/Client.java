package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.exceptions.InvalidBotCountException;
import TicTacToe.exceptions.InvalidMoveException;
import TicTacToe.exceptions.InvalidPlayerCountException;
import TicTacToe.models.*;
import TicTacToe.strategies.WinningStrategies.ColumnWinningStrategy;
import TicTacToe.strategies.WinningStrategies.DiagonalWinningStrategy;
import TicTacToe.strategies.WinningStrategies.RowWinningStrategy;
import TicTacToe.strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerCountException, InvalidMoveException {
        int dimension = 3;
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Hari", new Symbol('X'), PlayerType.HUMAN));
        playerList.add(new Bot("Neha", new Symbol('O'), BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = new ArrayList<>();

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();
        Game game = gameController.startGame(dimension, playerList, winningStrategies);


        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        if (game.getGameState().equals(GameState.ENDED)) {
            gameController.printBoard(game);
            System.out.println("Winner is " + gameController.getWinner(game).getPlayerName());
        }else{
            System.out.println("The game is DRAWN");
        }
    }
}
