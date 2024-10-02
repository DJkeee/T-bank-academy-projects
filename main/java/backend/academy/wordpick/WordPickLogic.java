package backend.academy.wordpick;

import backend.academy.wordscollection.Word;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class WordPickLogic {
    private final ArrayList<Word> words;
    private final Random random;

    public WordPickLogic(ArrayList<Word> arraywords) {
        this.words = arraywords;
        this.random = new SecureRandom();
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public Word getRandom() {
        int randInd = random.nextInt(words.size());
        return words.get(randInd);
    }

    public Word getRandWordByTheme(String theme) {
        List<Word> wordsByTheme = words
            .stream()
            .filter(word -> word.getTheme()
                .equalsIgnoreCase(theme))
            .toList();
        int randInd = random.nextInt(wordsByTheme.size());
        return wordsByTheme.get(randInd);
    }

    public Word pickRandomOrByTheme(String theme) {
        if ("random".equalsIgnoreCase(theme)) {
            return getRandom();
        } else {
            return getRandWordByTheme(theme);
        }
    }

}

