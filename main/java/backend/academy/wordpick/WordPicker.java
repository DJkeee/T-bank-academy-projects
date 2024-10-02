package backend.academy.wordpick;

import backend.academy.input.Input;
import backend.academy.wordscollection.Word;
import java.util.ArrayList;

public final class WordPicker {
    private final WordPickLogic logic;
    private final WordPickUI ui;

    public WordPicker(ArrayList<Word> words) {
        this.logic = new WordPickLogic(words);
        this.ui = new WordPickUI(this.logic);
    }

    public Word chooseByTheme() {
        ui.printAvailableThemes();
        // Запрашиваем тему у пользователя
        String theme = Input.theme(logic.getWords());
        return logic.pickRandomOrByTheme(theme);

    }
}
