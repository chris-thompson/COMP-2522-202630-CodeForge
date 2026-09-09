package ca.bcit.comp2522.innerClasses;

/**
 * A Game has moves.
 */
interface Game {

    /**
     * Moves something in the game.
     * @return true or false depending on some test
     */
    boolean move();
}

/**
 * A GameFactory produces a Game.
 */
interface GameFactory {

    /**
     * Returns a Game.
     * @return game an implementation of the Game interface
     */
    Game getGame();
}

/**
 * Checkers is an implementation of the Game interface.
 */
final class Checkers implements Game {

    /**
     * Check this out. It's a public static variable. Static means it's always available
     * even before a Checkers is instantiated. This is an anonymous GameFactory
     * object.
     */
    public static final GameFactory CHECKERS_FACTORY = new GameFactory() {

        /**
         * Returns an instance of the Checkers game.
         * @return checkers an instance of Checkers.
         */
        @Override
        public Game getGame() {
            return new Checkers();
        }
    };

    private static final int MOVES = 3;
    private int moves = 0;

    private Checkers() {
    }

    /**
     * Moves in the game.
     * @return true if more moves remain, else false
     */
    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

/**
 * Chess is an implementation of the Game interface.
 */
final class Chess implements Game {

    /**
     * Check this out. It's a public static variable. Static means it's always available
     * even before a Chess is instantiated. This is an anonymous GameFactory
     * object.
     */
    public static final GameFactory CHESS_FACTORY = new GameFactory() {

        /**
         * Returns an instance of the Chess game.
         * @return chess an instance of Chess.
         */
        @Override
        public Game getGame() {
            return new Chess();
        }
    };

    private static final int MOVES = 4;
    private int moves = 0;

    private Chess() {
    }

    /**
     * Moves in the game.
     * @return true if more moves remain, else false
     */
    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }
}

/**
 * Shows us how to use abstract factories. This is a very cool design pattern.
 *
 * @author BCIT
 * @version 2026
 */
public final class Games {

    private Games() {
    }

    /**
     * A service consumer accepts a factory as a parameter, extracts a
     * service from the factory, and then asks the service to act.
     * @param gameFactory an implementation of GameFactory
     */
    static void playGame(final GameFactory gameFactory) {
        Game aFunGame = gameFactory.getGame();
        while (aFunGame.move()) {
            System.out.println("Am I winning yet?");
        }
    }

    /**
     * Drives the program.
     * @param args unused.
     */
    public static void main(final String[] args) {
        playGame(Checkers.CHECKERS_FACTORY);
        playGame(Chess.CHESS_FACTORY);
    }
}
