package backend.academy.hangman;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

final public class HangmanUI {
    private static final PrintStream PRINT = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    private final HangmanLogic game;

    HangmanUI(HangmanLogic game) {
        this.game = game;
    }

    //изменил логику вырисовки виселицы
    @SuppressWarnings({"MultipleStringLiterals", "magicnumber"})
    public void drawHangman() {
        PRINT.println("  +---+");
        PRINT.println("  |   |");

        if (game.getLives() > 6) {
            for (int i = 0; i < game.getLives() - 6; i++) {
                PRINT.println("      |");
            }
        } else {
            switch (game.getLives()) {
                case 6:
                    PRINT.println("      |");
                    PRINT.println("      |");
                    PRINT.println("      |");
                    break;
                case 5:
                    PRINT.println("  O   |");
                    PRINT.println("      |");
                    PRINT.println("      |");
                    break;
                case 4:
                    PRINT.println("  O   |");
                    PRINT.println("  |   |");
                    PRINT.println("      |");
                    break;
                case 3:
                    PRINT.println("  O   |");
                    PRINT.println(" /|   |");
                    PRINT.println("      |");
                    break;
                case 2:
                    PRINT.println("  O   |");
                    PRINT.println(" /|\\  |");
                    PRINT.println("      |");
                    break;
                case 1:
                    PRINT.println("  O   |");
                    PRINT.println(" /|\\  |");
                    PRINT.println(" /    |");
                    break;
                case 0:
                    PRINT.println("  O   |");
                    PRINT.println(" /|\\  |");
                    PRINT.println(" / \\  |");
                    break;
                default:
                    break;
            }
        }
        PRINT.println("      |");
        PRINT.println("=========");
    }

    public void displayTheme() {
        PRINT.println("Ваша тема: " + game.getWord().getTheme());
    }

    public void promptForLetter() {
        PRINT.print("Введите букву или '+' для подсказки: ");
    }

    public void displayLives() {
        PRINT.println("У вас " + game.getLives() + " жизней");
    }

    public void displayWordState() {
        PRINT.println("слово: " + game.getWordState());
    }

    public void displayGameOver() {
        if (game.isPlayerWon()) {
            PRINT.println("Вы победили - поздравляем \n");
        } else {
            PRINT.println("Вы проиграли, ваше слово было " + game.getWord().getWord() + "\n");
        }
    }

    public void displayHint() {
        PRINT.println(game.getWord().getHint());
    }

}

