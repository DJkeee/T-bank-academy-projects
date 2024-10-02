package backend.academy;

import lombok.experimental.UtilityClass;

//Входная точка программы или же Main
@UtilityClass
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
