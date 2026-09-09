package ca.bcit.comp2522.exceptions;

/**
 * Demonstrates an uncaught exception.
 *
 * @author BCIT
 * @version 2026
 */
public final class AnIntentionalException {

    private AnIntentionalException() {

    }

    /**
     * Deliberately divides by zero to produce an exception.
     *
     * @param args command line arguments (unused)
     */
    @SuppressWarnings("divzero")
    public static void main(final String[] args) {
        final int numerator = 100;
        final int denominator = 0;

        // Dividing by zero is the entire point of this file, so the warning
        // javac would normally print here is switched off deliberately. Note
        // that javac spotted this at compile time only because both values are
        // constants; had they been read from a user it could not have known.
        System.out.println(numerator / denominator);

        System.out.println("Will this be printed?");
    }
}
