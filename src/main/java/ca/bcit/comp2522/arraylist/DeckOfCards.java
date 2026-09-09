package ca.bcit.comp2522.arraylist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Card.
 *
 * @author BCIT
 * @version 2026
 */
class Card {

    /**
     * Faces.
     */
    public enum Face {
        Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }

    /**
     * Suits.
     */
    public enum Suit {
        Clubs, Diamonds, Hearts, Spades
    }

    private final Face face;
    private final Suit suit;

    /**
     * Constructs an object of type Card.
     * @param cardFace a Face
     * @param cardSuit a Suit
     */
    Card(final Face cardFace, final Suit cardSuit) {
        face = cardFace;
        suit = cardSuit;
    }

    /**
     * Returns the face.
     * @return face a Face
     */
    public Face getFace() {
        return face;
    }

    /**
     * Returns the suit.
     * @return suit a Suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Compares this Card to another Object for equality.
     * @param object an Object
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Card card = (Card) object;

        if (getFace() != card.getFace()) {
            return false;
        }
        return getSuit() == card.getSuit();
    }

    /**
     * Returns a hash code for this Card.
     * @return a hash code
     */
    @Override
    public int hashCode() {
        int result = getFace().hashCode();
        final int usefulPrime = 31;
        result = usefulPrime * result + getSuit().hashCode();
        return result;
    }

    /**
     * Returns a String representation of this Card.
     * @return a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Card{");
        sb.append("face=").append(getFace());
        sb.append(", suit=").append(getSuit());
        sb.append('}');
        return sb.toString();
    }
}

/**
 * Deck of cards.
 *
 * @author BCIT
 * @version 2026
 */
public class DeckOfCards {

    private final List<Card> deck;

    /**
     * Constructs an object of type DeckOfCards.
     */
    public DeckOfCards() {
        final int deckSize = 52;
        Card[] cards = new Card[deckSize];
        int count = 0;

        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Face face : Card.Face.values()) {
                cards[count] = new Card(face, suit);
                count++;
            }
        }
        this.deck = Arrays.asList(cards);
        Collections.shuffle(this.deck);
    }

    /**
     * Prints the cards in the Deck.
     */
    public void printCards() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        DeckOfCards cards = new DeckOfCards();
        cards.printCards();
    }
}
