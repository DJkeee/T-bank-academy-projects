package backend.academy.samples;

import backend.academy.wordscollection.Word;
import backend.academy.hangman.HangmanLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HangmanLogicTests {

    @Test
    public void testIsLetterInWord_True() {
        Word word = new Word("hello", "theme", "tip");
        HangmanLogic game = new HangmanLogic(word, 10);
        assertTrue(game.isLetterInWord('e'));
    }

    @Test
    public void testIsLetterInWord_False() {
        Word word = new Word("hello", "theme", "tip");
        HangmanLogic game = new HangmanLogic(word, 10);
        assertFalse(game.isLetterInWord('x'));
    }

    @Test
    public void testGetWordState_Initial() {
        Word word = new Word("hello", "theme", "tip");
        HangmanLogic game = new HangmanLogic(word, 10);
        assertEquals("_____", game.getWordState());
    }

    @Test
    public void testGetWordState_GuessedLetter() {
        Word word = new Word("hello", "theme", "tip");
        HangmanLogic game = new HangmanLogic(word, 10);
        game.guessLetter('e');
        assertEquals("__e_e", game.getWordState());
    }

    @Test
    public void testIsPlayerWon_True() {
        Word word = new Word("hello", "theme", "tip");
        HangmanLogic game = new HangmanLogic(word, 10);
        game.guessLetter('t');
        game.guessLetter('h');
        game.guessLetter('e');
        game.guessLetter('m');
        assertTrue(game.isPlayerWon());
    }

    @Test
    public void testIsPlayerWon_False() {
        Word word = new Word("hello", "theme", "tip");
        HangmanLogic game = new HangmanLogic(word, 10);
        assertFalse(game.isPlayerWon());
    }

    @Test
    public void testIsPlayerLost_True() {
        Word word = new Word("hello", "theme", "tip");
        HangmanLogic game = new HangmanLogic(word, 0);
        assertTrue(game.isPlayerLost());
    }

    @Test
    public void testIsPlayerLost_False() {
        Word word = new Word("hello", "theme", "tip");
        HangmanLogic game = new HangmanLogic(word, 10);
        assertFalse(game.isPlayerLost());
    }

}
