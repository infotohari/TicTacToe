package TicTacToe.models;


import TicTacToe.factory.BotPlayingStrategyFactory;
import TicTacToe.strategies.BotWinningStrategies.BotWinningStrategy;

//bot is type of a player so it will extend Player class
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotWinningStrategy botPlayingStrategy;

    // constructor
    public Bot(String playerName,Symbol symbol ,BotDifficultyLevel botDifficultyLevel) {
        super(playerName, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }


    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotWinningStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotWinningStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move makeMove(Board board) {
       Move move = botPlayingStrategy.makeMove(board);
       return move;
    }
}
