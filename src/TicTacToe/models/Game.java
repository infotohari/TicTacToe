package TicTacToe.models;

import TicTacToe.exceptions.InvalidBotCountException;
import TicTacToe.exceptions.InvalidPlayerCountException;
import TicTacToe.strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner ;
    private GameState gameState;
    private int nextPlayerMoveIndex ;
    List<WinningStrategy> winningStrategies;

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerMoveIndex = 0;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void makeMove() {

    }

    public void printBoard(){
        board.print();
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }


    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static class Builder{
        private int dimension; // using dimension we can create a board
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        //BOT Count validation

        private void validateBotCount () throws InvalidBotCountException {
           int botCount = 0;
           for (Player player : players) {
               if(player.getPlayerType() == PlayerType.BOT){
                   botCount++;
               }
           }

           if(botCount > 1){
               throw new InvalidBotCountException("Bot count is greater than expected");
           }
        }

        public void validatePlayerCount() throws InvalidPlayerCountException {
            if (players.size() != dimension-1){
                throw new InvalidPlayerCountException("Unexpected player count");
            }
        }

        public void validateUniqueSymbolException(){

        }

        public void validate() throws InvalidBotCountException, InvalidPlayerCountException {
            validateBotCount();
            validatePlayerCount();
            validateUniqueSymbolException();
        }

        public Game build () throws InvalidPlayerCountException, InvalidBotCountException {
            validate();
            Game game = new Game(dimension, players, winningStrategies);
            return game;

        }
    }
}
