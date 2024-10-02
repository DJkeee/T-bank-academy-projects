package backend.academy.wordpick;

import backend.academy.wordscollection.Word;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class WordPickUI {
    private static final PrintStream PRINT = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    private final WordPickLogic logic;

    public WordPickUI(WordPickLogic logic) {
        this.logic = logic;
    }

    public void printAvailableThemes() {
        PRINT.println('\n');
        List<String> themes = logic.getWords()
            .stream()
            .map(Word::getTheme)
            .distinct()
            .toList();
        for (String theme : themes) {
            PRINT.println("- " + theme.toLowerCase());
        }
    }
}
