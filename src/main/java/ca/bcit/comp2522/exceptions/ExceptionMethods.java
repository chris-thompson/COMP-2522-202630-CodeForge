package ca.bcit.comp2522.exceptions;

/**
 * Demonstrates how to use common Exception methods.
 *
 * @author BCIT
 * @version 2026
 */
public final class ExceptionMethods {

    private ExceptionMethods() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        try {
            throw new NullPointerException("Here's my NullPointerException");
        } catch (NullPointerException e) {
            System.err.println("Caught Exception");
            System.err.println("e.getMessage(): " + e.getMessage());
            System.err.println("e.getLocalizedMessage(): " + e.getLocalizedMessage());
            System.err.println("e.toString(): " + e);
            System.err.println("e.printStackTrace():");
            e.printStackTrace(System.err);
        }
    }
}
