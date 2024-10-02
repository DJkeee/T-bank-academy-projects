package backend.academy.input;

@SuppressWarnings("uncheked")
interface Validator<T> {
    boolean validate(T input);
}

