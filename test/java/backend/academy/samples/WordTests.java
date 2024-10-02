package backend.academy.samples;

import backend.academy.wordscollection.Word;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordTests {

@Test
void testConstructor() {
    String theme = "Animals";
    String word = "Cat";
    String hintText = "A furry friend";

    Word wordObject = new Word(theme, word, hintText);

    assertEquals(theme.toLowerCase(), wordObject.getTheme());
    assertEquals(word.toLowerCase(), wordObject.getWord());
    assertEquals(hintText.toLowerCase(), wordObject.getHint());
}

@Test
void testGetters() {
    String theme = "Animals";
    String word = "Dog";
    String hintText = "Man's best friend";

    Word wordObject = new Word(theme, word, hintText);

    assertEquals(theme.toLowerCase(), wordObject.getTheme());
    assertEquals(word.toLowerCase(), wordObject.getWord());
    assertEquals(hintText.toLowerCase(), wordObject.getHint());
}

@Test
void testWordToLowercase() {
    String theme = "Animals";
    String word = "DOG";
    String hintText = "Man's best friend";

    Word wordObject = new Word(theme, word, hintText);

    assertEquals(word.toLowerCase(), wordObject.getWord());
}

@Test
void testThemeToLowercase() {
    String theme = "ANIMALS";
    String word = "Dog";
    String hintText = "Man's best friend";

    Word wordObject = new Word(theme, word, hintText);

    assertEquals(theme.toLowerCase(), wordObject.getTheme());
}

@Test
void testHintToLowercase() {
    String theme = "Animals";
    String word = "Dog";
    String hintText = "MAN'S BEST FRIEND";

    Word wordObject = new Word(theme, word, hintText);

    assertEquals(hintText.toLowerCase(), wordObject.getHint());
}
}
