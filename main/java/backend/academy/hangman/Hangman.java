package backend.academy.hangman;

import backend.academy.input.Input;
import backend.academy.wordscollection.Word;

final public class Hangman {
    private final HangmanLogic game;
    private final HangmanUI ui;

    public Hangman(Word word, int initLives) {
        this.game = new HangmanLogic(word, initLives);
        this.ui = new HangmanUI(this.game);
    }

    //@SuppressWarnings("MultipleStringLiterals")
    public void playRound(char letter) {
        if (game.hintRequest(letter)) {
            ui.drawHangman();
            ui.displayLives();
            ui.displayHint();
            return;
        }
        game.guessLetter(letter);
        ui.drawHangman();
        ui.displayLives();
        ui.displayWordState();
    }

    public void playGame() {
        while (!game.isGameOver()) {
            ui.displayTheme();
            ui.promptForLetter();
            playRound(Input.letter());
        }
        ui.displayGameOver();
        }
    }

