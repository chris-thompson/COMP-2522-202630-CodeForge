package ca.bcit.comp2522.printingAndConcatenation;

/**
 * Demonstrates the difference between the addition and string concatenation
 * operators.
 *
 * The + operator does two entirely different jobs depending on what sits
 * either side of it. With two numbers it adds. With a String on either side
 * it concatenates, converting the other operand to a String first. Because
 * + is evaluated left to right, "" + 24 + 45 gives "2445": the first + has
 * already produced a String by the time the second one runs.
 *
 * The two numbers are the example, so MagicNumber is reported here on
 * purpose.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Addition {

    private Addition() { }

    /**
     * Concatenates and adds two numbers, then prints the results.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        System.out.println("24 and 45 concatenated: " + 24 + 45);
        System.out.println("24 and 45 added: " + (24 + 45));
    }
}
