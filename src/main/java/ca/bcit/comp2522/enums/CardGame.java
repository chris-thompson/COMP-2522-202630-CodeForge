package ca.bcit.comp2522.enums;

import java.util.Random;

/**
 * CardGame demonstrates the use of enumerations.
 *
 * @author BCIT
 * @version 2026
 */
public final class CardGame {

    private CardGame() {
    }

    /**
     * Rank of a playing card.
     */
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEV, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    /**
     * Suit of a playing card.
     */
    public enum Suit {
        HEARTS, DIAMONDS, SPADES, CLUBS
    }

    /**
     * Runs the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {

        final Random random = new Random();

        final int randomRankChoice = random.nextInt(Rank.values().length);
        final Rank randomRank = Rank.values()[randomRankChoice];

        final int randomSuitChoice = random.nextInt(Suit.values().length);
        final var randomSuit = Suit.values()[randomSuitChoice];

        System.out.println("You selected: " + randomRank + " of " + randomSuit);
    }
}
