package ca.bcit.comp2522.strings;

/**
 * Demonstrates String.format and its placeholders.
 *
 * String.format builds a String from a template. Everywhere you write a
 * placeholder beginning with %, format substitutes the next argument you
 * passed, converted according to the letter that follows:
 *
 *   %s   any object, converted with its toString method
 *   %d   a whole number
 *   %f   a floating point number; %.2f rounds it to two decimal places
 *   %b   a boolean
 *   %n   a line separator that is correct for the current operating system
 *
 * System.out.printf does the same thing and prints the result in one step,
 * which is usually what you want.
 *
 * @author BCIT
 * @version 2026
 */
public final class FormatTester {

    /** Used to turn a fraction into a percentage. */
    private static final int PER_CENT = 100;

    private FormatTester() {
    }

    /**
     * Formats and prints several values.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final String booleanExample = String.format("Is the course full? %b", false);
        System.out.println(booleanExample);

        final String studentName = "Priya";
        final String stringExample = String.format("Welcome to COMP 2522, %s!", studentName);
        System.out.println(stringExample);

        // The arguments are substituted in order, left to right. Get the order
        // or the count wrong and you get an exception at run time, not a
        // compile error, which is one reason to prefer printf's cousin: a
        // plain concatenation is checked by the compiler.
        final int labsCompleted = 3;
        final double averageMark = 0.8725;
        System.out.println(String.format("%s has finished %d labs, averaging %.1f%%",
                studentName, labsCompleted, averageMark * PER_CENT));

        // printf formats and prints together. Note the explicit %n at the end:
        // printf does not add a line ending for you the way println does.
        System.out.printf("Padded and aligned: |%10s|%-10s|%n", "right", "left");
    }
}
