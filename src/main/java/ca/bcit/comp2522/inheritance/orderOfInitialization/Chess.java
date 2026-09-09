package ca.bcit.comp2522.inheritance.orderOfInitialization;

class Game {
    Game(final int someValue) {
        System.out.println("Game constructor received " + someValue);
    }
}

class BoardGame extends Game {
    BoardGame(final int someValue) {
        super(someValue);
        System.out.println("BoardGame constructor");
    }
}

/**
 * Pay attention to the order of execution.  This is quite
 * linear, but it demonstrates the fundamental principle
 * that the calls to super go all the way up the hierarchy.
 *
 * @author BCIT
 * @version 2026
 */
public class Chess extends BoardGame {

    private static final int USEFUL_PRIME = 11;

    /**
     * Constructs an object of type Chess.
     */
    public Chess() {
        super(USEFUL_PRIME);
        System.out.println("Chess constructor");
    }

    /**
     * Drives the program.
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        Chess chessGame = new Chess();
        System.out.println(chessGame);
    }
}
