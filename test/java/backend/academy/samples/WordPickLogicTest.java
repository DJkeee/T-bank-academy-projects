package backend.academy.samples;

import backend.academy.wordscollection.*;
import backend.academy.wordpick.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WordPickLogicTest {

    @Test
    void testGetRandom() {
        ArrayList<Word> words = new ArrayList<>(Arrays.asList(
            new Word("animals", "apple", "man's best friend"),
            new Word("fruits", "apple", "red fruit")
        ));
        WordPickLogic wordPickLogic = new WordPickLogic(words);
        Word randomWord = wordPickLogic.getRandom();
        assertEquals("apple", randomWord.getWord());
    }

    @Test
    void testGetRandWordByTheme() {
        ArrayList<Word> words = new ArrayList<>(Arrays.asList(
            new Word("animals", "dog", "man's best friend"),
            new Word("fruits", "banana", "red fruit"),
            new Word("fruits", "banana", "yellow fruit")
        ));
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(2)).thenReturn(1); // Возвращаем 1, чтобы получить "banana"
        WordPickLogic wordPickLogic = new WordPickLogic(words);
        Word wordByTheme = wordPickLogic.getRandWordByTheme("fruits");
        assertEquals("banana", wordByTheme.getWord());
    }

    @Test
    void testPickRandomOrByThemeRandom() {
        ArrayList<Word> words = new ArrayList<>(Arrays.asList(
            new Word("animals", "apple", "man's best friend"),
            new Word("fruits", "apple", "red fruit")
        ));
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(words.size())).thenReturn(1); // Возвращаем 1, чтобы получить "apple"
        WordPickLogic wordPickLogic = new WordPickLogic(words);
        Word pickedWord = wordPickLogic.pickRandomOrByTheme("random");
        assertEquals("apple", pickedWord.getWord());
    }

    @Test
    void testPickRandomOrByThemeByTheme() {
        ArrayList<Word> words = new ArrayList<>(Arrays.asList(
            new Word("animals", "dog", "man's best friend"),
            new Word("fruits", "banana", "red fruit"),
            new Word("fruits", "banana", "yellow fruit")
        ));
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(2)).thenReturn(1); // Возвращаем 1, чтобы получить "banana"
        WordPickLogic wordPickLogic = new WordPickLogic(words);
        Word pickedWord = wordPickLogic.pickRandomOrByTheme("fruits");
        assertEquals("banana", pickedWord.getWord());
    }
}
