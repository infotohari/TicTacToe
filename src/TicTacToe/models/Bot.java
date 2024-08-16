package TicTacToe.models;


import TicTacToe.strategies.BotWinningStrategies.BotWinningStrategy;

//bot is type of a player so it will extend Player class
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotWinningStrategy botWinningStrategy ;

    // constructor
    public Bot(String playerName,Symbol symbol ,BotDifficultyLevel botDifficultyLevel, BotWinningStrategy botWinningStrategy) {
        super(playerName, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botWinningStrategy = botWinningStrategy;
    }


    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotWinningStrategy getBotWinningStrategy() {
        return botWinningStrategy;
    }

    public void setBotWinningStrategy(BotWinningStrategy botWinningStrategy) {
        this.botWinningStrategy = botWinningStrategy;
    }
}
