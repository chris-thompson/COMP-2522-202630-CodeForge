package ca.bcit.comp2522.controlStatements;

/**
 * Demonstrates the use of nested for loops.
 *
 * @author BCIT
 * @author BCIT
 * @version 2026
 */
public final class Wedge {

    private Wedge() { }

    /**
     * Prints a wedge shape using asterisk (star) characters.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final int maxRows = 11;

        for (int row = 1; row <= maxRows; row++) {
            for (int blanks = 1; blanks <= maxRows - row; blanks++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
