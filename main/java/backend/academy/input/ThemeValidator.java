package backend.academy.input;

import backend.academy.wordscollection.Word;
import java.util.ArrayList;

class ThemeValidator implements Validator<String> {
    private final ArrayList<Word> wordsList;

    ThemeValidator(ArrayList<Word> wordsList) {
        this.wordsList = wordsList;
    }

    @Override
    public boolean validate(String input) {
        if (input.isBlank()) {
            return true; // Allow empty input for random theme
        }

        return wordsList.stream()
            .anyMatch(word -> word.getTheme().equalsIgnoreCase(input));
    }
}

