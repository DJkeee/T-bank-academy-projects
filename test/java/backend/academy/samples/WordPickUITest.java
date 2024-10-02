package backend.academy.samples;

import backend.academy.wordscollection.Word;
import backend.academy.wordpick.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WordPickUITest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    @Disabled("Ложноположительный")
    void testPrintAvailableThemes() {
        // Подготовка мока
        WordPickLogic mockLogic = mock(WordPickLogic.class);
        List<Word> words = new ArrayList<>();
        words.add(new Word("animals", "dog", "man's best friend"));
        words.add(new Word("fruits", "apple", "red fruit"));
        words.add(new Word("animals", "cat", "furry friend"));
        when(mockLogic.getWords()).thenReturn((ArrayList<Word>) words);

        // Перенаправление System.out
        System.setOut(new PrintStream(outputStreamCaptor));

        // Создание объекта WordPickUI
        WordPickUI wordPickUI = new WordPickUI(mockLogic);

        // Вызов метода printAvailableThemes
        wordPickUI.printAvailableThemes();

        // Проверка вывода
        String expectedOutput = "\n" +
            "- animals\n" +
            "- fruits\n";

        assertEquals(expectedOutput, outputStreamCaptor.toString(StandardCharsets.UTF_8));

        // Восстановление System.out
        System.setOut(originalOut);
    }
}
