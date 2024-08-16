package TicTacToe.models;

public class Player {

    private String playerName ;
    private Symbol Symbol ;
    private PlayerType playerType ;

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
}

