package TicTacToe.models;

import TicTacToe.exceptions.InvalidBotCountException;
import TicTacToe.exceptions.InvalidMoveException;
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

    private boolean validateMove(Move move){
        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getCol();

        //validating if row col is within limit
        if(row >= board.getDimension() || col >= board.getDimension() || row < 0 || col < 0){
            return false;
        }

        if(board.getBoard().get(row).get(col).getCellState() == (CellState.FILLED)){
            return false;
        }

        return true;
    }

    private boolean checkWinner(Move move){
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(move, board)){
                return true;
            }
        }
        return false;
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("It is " + currentPlayer.getPlayerName() + "'s turn");

        //ask player to make move
        Move move = currentPlayer.makeMove(board);

        //validate the move before executing (validate if cell is not empty
        if (!validateMove(move)){
            throw new InvalidMoveException("Invalid move");
        }

        //valid move
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        Move finalMove = new Move(currentPlayer, cell);
        moves.add(finalMove);

        // to move the game to next player
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();

        // check winner
        if(checkWinner(finalMove)){
            gameState = GameState.ENDED;
            winner = currentPlayer;
        }else if(moves.size() == board.getDimension() * board.getDimension()){
            gameState = GameState.DRAW;
        }

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
