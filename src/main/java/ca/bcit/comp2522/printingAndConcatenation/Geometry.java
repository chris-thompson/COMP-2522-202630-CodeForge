package ca.bcit.comp2522.printingAndConcatenation;

/**
 * Demonstrates the use of an assignment statement to change the value stored in
 * a variable.
 *
 * The side counts are the example, so MagicNumber is reported deliberately.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Geometry {

    private Geometry() {
    }

    /**
     * Prints the number of sides of several geometric shapes.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        int sides = 7; // declaration with initialization
        System.out.println("A heptagon has " + sides + " sides.");

        sides = 10; // assignment statement
        System.out.println("A decagon has " + sides + " sides.");

        sides = 12;
        System.out.println("A dodecagon has " + sides + " sides.");
    }
}
