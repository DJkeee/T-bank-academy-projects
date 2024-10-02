package backend.academy.hangman;

import backend.academy.wordscollection.Word;
import java.util.HashSet;
import java.util.Set;

public final class HangmanLogic {
    private final Word word;
    private final Set<Character> guessedLetters;
    private int lives;

    public HangmanLogic(Word word, int initialLives) {
        this.word = word;
        this.lives = initialLives;
        this.guessedLetters = new HashSet<>();
    }

    public void guessLetter(char letter) {
        guessedLetters.add(letter); // Добавляем букву
        if (!isLetterInWord(letter)) {
            lives--;
        }
    }

    public boolean isLetterInWord(Character letter) {
        return word.getWord().toLowerCase().contains(String.valueOf(letter).toLowerCase());
    }

    public int getLives() {
        return this.lives;
    }

    public Word getWord() {
        return word;
    }

    public boolean isPlayerWon() {
        return getWordState().equals(word.getWord());
    }

    public boolean isPlayerLost() {
        return lives == 0;
    }

    public boolean isGameOver() {
        return isPlayerLost() || isPlayerWon();
    }

    public String getWordState() {
        StringBuilder wordState = new StringBuilder();
        for (char ch : word.getWord().toCharArray()) {
            if (guessedLetters.contains(Character.toLowerCase(ch))) {
                wordState.append(ch);
            } else {
                wordState.append('_'); //рисуем _ если букву не угадали
            }
        }
        return wordState.toString();
    }

    public boolean hintRequest(char letter) {
        return '+' == letter;
    }

}
