package ca.bcit.comp2522.numbers;

import java.util.Random;

/**
 * Demonstrates pseudo-random numbers using the Random class.
 *
 * "Pseudo-random" means the numbers are not really random at all. They are
 * produced by an arithmetic formula from a starting value called the seed, and
 * the same seed always produces the same sequence. That is a feature, not a
 * flaw: it is what makes a program that uses randomness testable. Random()
 * with no argument seeds itself from the system clock, so you get a different
 * sequence each run; new Random(42) would give you the same one every time.
 *
 * Note the shape of every call below. nextInt(n) returns a value from 0 up to
 * but NOT including n. Almost every off-by-one bug with Random comes from
 * forgetting that the upper bound is excluded, so to get a die roll from 1 to
 * 6 you write nextInt(6) + 1, not nextInt(7).
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class RandomNumbers {

    /** Number of sides on an ordinary die. */
    private static final int SIDES_ON_A_DIE = 6;

    /** Upper bound, exclusive, for the single-digit examples. */
    private static final int SINGLE_DIGIT_BOUND = 10;

    /** How many distinct values the shifted-range example spans. */
    private static final int RANGE_WIDTH = 15;

    /** Where the shifted-range example starts. */
    private static final int RANGE_START = 20;

    private RandomNumbers() {
    }

    /**
     * Generates random numbers in various ranges and prints them.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        // One generator, created once and reused. Creating a new Random for
        // every number is slower and, on a fast machine, can hand you the same
        // value repeatedly because two generators seeded in the same
        // millisecond produce the same sequence.
        final Random generator = new Random();

        // With no bound at all you get the full range of int, positive or
        // negative. This is rarely what you want.
        int randomInteger = generator.nextInt();
        System.out.println("A random integer: " + randomInteger);

        // 0 to 9: the bound is excluded.
        randomInteger = generator.nextInt(SINGLE_DIGIT_BOUND);
        System.out.println("From 0 to 9: " + randomInteger);

        // Adding 1 shifts the whole range up by one, giving 1 to 10.
        randomInteger = generator.nextInt(SINGLE_DIGIT_BOUND) + 1;
        System.out.println("From 1 to 10: " + randomInteger);

        // The general recipe: nextInt(howManyValues) + lowestValue.
        randomInteger = generator.nextInt(RANGE_WIDTH) + RANGE_START;
        System.out.println("From 20 to 34: " + randomInteger);

        // The shift can be negative too.
        randomInteger = generator.nextInt(RANGE_WIDTH + RANGE_WIDTH)
                - SINGLE_DIGIT_BOUND;
        System.out.println("From -10 to 19: " + randomInteger);

        // nextDouble gives a value in [0.0, 1.0) — zero is possible, one is not.
        final double randomFraction = generator.nextDouble();
        System.out.println("A random double between 0 and 1: " + randomFraction);

        // Scaling that fraction up and truncating is the long way round to a
        // die roll. nextInt(SIDES_ON_A_DIE) + 1 is clearer and is what you
        // should actually write; this is here so you can see why it works.
        final int dieRoll = (int) (generator.nextDouble() * SIDES_ON_A_DIE) + 1;
        System.out.println("From 1 to 6, the long way: " + dieRoll);
        System.out.println("From 1 to 6, the short way: "
                + (generator.nextInt(SIDES_ON_A_DIE) + 1));
    }
}
