package backend.academy.input;

import backend.academy.wordscollection.Word;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

final public class Input {
    private static final Scanner INPUT = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    private static final PrintStream PRINT = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    private Input() {
    }

    public static Character letter() {
        LetterValidator validator = new LetterValidator();
        while (true) {
            String input = INPUT.nextLine().trim().toLowerCase();
            if (validator.validate(input)) {
                return input.charAt(0);
            } else {
                PRINT.println("Пожалуйста, введите одну букву или '+'");
            }
        }
    }

    public static String theme(ArrayList<Word> wordsList) {
        ThemeValidator validator = new ThemeValidator(wordsList);
        while (true) {
            PRINT.println("Введите тему (или оставьте пустым для случайного слова): ");
            if (INPUT.hasNextLine()) {
                String theme = INPUT.nextLine().trim().toLowerCase();
                if (validator.validate(theme)) {
                    return theme.isEmpty() ? "random" : theme;
                } else {
                    PRINT.println("Такой темы нет в словаре, "
                        + "введите ее еще раз корректно."
                        + " Либо ничего не вводите и тема будет выбрана случайно.\n");
                }
            } else {
                PRINT.println("Некорректный ввод.Попробуйте снова.\n");

            }
        }
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static String difficulty() {
        DifficultyValidator validator = new DifficultyValidator();
        while (true) {
            if (INPUT.hasNextLine()) {
                String difficulty = INPUT.nextLine();
                if (difficulty.isBlank()) {
                    return "средний";
                }
                if (validator.validate(difficulty)) {
                    return difficulty;
                } else {
                    PRINT.println("Неверный ввод сложности. Попробуйте снова.\n");
                }
            } else {
                PRINT.println("Некорректный ввод. Попробуйте снова.\n");
                INPUT.next(); // Считываем следующий ввод, чтобы избежать зацикливания
            }
        }
    }

    public static int readLivesInterval(int min, int max) {
        LivesIntervalValidator validator = new LivesIntervalValidator(min, max);
        int number = 0;
        while (true) {
            try {
                PRINT.print("Введите количество жизней от " + min + " до " + max + ": ");
                number = INPUT.nextInt();
                INPUT.nextLine();
                if (validator.validate(number)) {
                    return number;
                } else {
                    PRINT.println("Число вне диапазона. Попробуйте еще раз.");
                }
            } catch (InputMismatchException e) {
                PRINT.println("Некорректный ввод. Введите число.");
                INPUT.nextLine();
            }
        }
    }
}

