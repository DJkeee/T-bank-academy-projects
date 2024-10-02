package backend.academy.input;

class LivesIntervalValidator implements Validator<Integer> {
    final private int min;
    final private int max;

    LivesIntervalValidator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean validate(Integer input) {
        return input >= min && input <= max;
    }
}
