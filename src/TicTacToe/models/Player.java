package TicTacToe.models;

import java.util.Scanner;

public class Player {

    private String playerName ;
    private Symbol Symbol ;
    private PlayerType playerType ;
    private static Scanner scanner = new Scanner(System.in);

    //Creating Manual Constructor
    public Player(String playerName, Symbol symbol, PlayerType playerType) {
        this.playerName = playerName;
        this.Symbol = symbol;
        this.playerType = playerType;
    }


    public String getPlayerName() {
        return playerName;
    }

    public TicTacToe.models.Symbol getSymbol() {
        return Symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setSymbol(TicTacToe.models.Symbol symbol) {
        Symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        System.out.println("Enter the row number");
        int row = scanner.nextInt();
        System.out.println("Enter the column number");
        int column = scanner.nextInt();

        return new Move(this, new Cell(row, column));
    }
}

