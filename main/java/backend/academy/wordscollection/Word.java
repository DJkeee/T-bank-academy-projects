package backend.academy.wordscollection;

public class Word {
    private String theme;
    private String word;
    private String hintText;

    public Word(String theme, String word, String hintText) {
        this.word = word.toLowerCase();
        this.theme = theme.toLowerCase();
        this.hintText = hintText.toLowerCase();
    }

    public String getTheme() {
        return theme;
    }

    public String getWord() {
        return word;
    }

    public String getHint() {
        return hintText;
    }

}
