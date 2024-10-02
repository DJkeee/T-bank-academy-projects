package backend.academy.input;

import java.util.HashSet;
import java.util.Set;

class DifficultyValidator implements Validator<String> {
    private final Set<String> validDifficulties;

    DifficultyValidator() {
        this.validDifficulties = new HashSet<>();
        validDifficulties.add("простой");
        validDifficulties.add("средний");
        validDifficulties.add("высокий");
    }

    @Override
    public boolean validate(String input) {
        return validDifficulties.contains(input.trim().toLowerCase());
    }
}

