package backend.academy.input;

class LetterValidator implements Validator<String> {
    @Override
    public boolean validate(String input) {
        return (input.length() == 1
            && Character.isLetter(input.charAt(0)))
            || "+".equals(input);
    }

}

