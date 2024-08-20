package TicTacToe.factory;

import TicTacToe.models.BotDifficultyLevel;
import TicTacToe.strategies.BotWinningStrategies.BotWinningStrategy;
import TicTacToe.strategies.BotWinningStrategies.EasyBotWinningStrategy;
import TicTacToe.strategies.BotWinningStrategies.HardBotWinningStrategy;
import TicTacToe.strategies.BotWinningStrategies.MediumBotWinningStrategy;

public class BotPlayingStrategyFactory {
    public static BotWinningStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        if (botDifficultyLevel == BotDifficultyLevel.EASY) {
            return new EasyBotWinningStrategy();
        }else if (botDifficultyLevel == BotDifficultyLevel.HARD) {
            return new HardBotWinningStrategy();
        }else return new MediumBotWinningStrategy();
    }
}
