package TicTacToe.controllers;

import TicTacToe.exceptions.InvalidBotCountException;
import TicTacToe.exceptions.InvalidPlayerCountException;
import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;
import TicTacToe.strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategies) throws InvalidPlayerCountException, InvalidBotCountException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(playerList)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

}
