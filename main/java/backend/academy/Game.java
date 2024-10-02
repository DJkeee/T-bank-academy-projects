package backend.academy;

import backend.academy.hangman.Hangman;
import backend.academy.input.Input;
import backend.academy.wordpick.WordPicker;
import backend.academy.wordscollection.Word;
import java.util.ArrayList;

public final class Game {
    ArrayList<Word> words;
    WordPicker picker;
    Hangman hangman;

    @SuppressWarnings("magicnumber")
    public Game() {
        this.words = Difficulty.wordsByDifficulty();
        this.picker = new WordPicker(words);
        Word word = picker.chooseByTheme();
        int lives = Input.readLivesInterval(4, 10);
        this.hangman = new Hangman(word, lives);
    }

    public void playGame() {
        hangman.playGame();
    }

}

