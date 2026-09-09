package ca.bcit.comp2522.strings;

/**
 * Demonstrates the use of the String class and its methods.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class StringMutation {

    private StringMutation() { }

    /**
     * Prints a String and various mutations of it.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final String phrase = "Change is inevitable";

        System.out.println("Original string: \"" + phrase + "\"");
        System.out.println("Length of string: " + phrase.length());

        final String mutation1 = phrase.concat(", except from vending machines.");
        final String mutation2 = mutation1.toUpperCase();
        final String mutation3 = mutation2.replace('E', 'X');

        // With magic numbers you may not understand the following:
        final String mutation4 = mutation3.substring(3, 30);

        // Prints each mutated string
        System.out.println("Mutation #1: " + mutation1);
        System.out.println("Mutation #2: " + mutation2);
        System.out.println("Mutation #3: " + mutation3);
        System.out.println("Mutation #4: " + mutation4);

        System.out.println("Mutated length: " + mutation4.length());
    }
}
