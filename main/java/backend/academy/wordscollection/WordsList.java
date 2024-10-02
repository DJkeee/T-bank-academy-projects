package backend.academy.wordscollection;

import java.util.ArrayList;

public final class WordsList {
    private final ArrayList<Word> wordsList;

    @SuppressWarnings("magicnumber")
    public WordsList(String[][] wordsArray) {
        int indextheme = 0;
        int indexword = 1;
        int indexhint = 2;
        this.wordsList = new ArrayList<>();
        for (String[] wordData : wordsArray) {
            Word word = new Word(wordData[indextheme], wordData[indexword], wordData[indexhint]);
            wordsList.add(word);
        }
    }

    public ArrayList<Word> getWordsList() {
        return wordsList;
    }

}
