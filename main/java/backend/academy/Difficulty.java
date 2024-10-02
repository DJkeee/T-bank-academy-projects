package backend.academy;

import backend.academy.input.Input;
import backend.academy.wordscollection.Word;
import backend.academy.wordscollection.WordsList;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Difficulty {
    private static final PrintStream PRINT = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    private Difficulty() {}

    public static ArrayList<Word> wordsByDifficulty() {
        PRINT.println("Введите уровень сложности: "
            + "простой, средний, высокий");
        String difficulty = Input.difficulty();

        return switch (difficulty) {
            case "простой" -> new WordsList(StringData.EASY).getWordsList();
            case "высокий" -> new WordsList(StringData.HARD).getWordsList();
            default -> new WordsList(StringData.NORMAL).getWordsList();
        };
    }
}
