package ca.bcit.comp2522.printingAndConcatenation;

/**
 * Demonstrates the use of the string concatenation operator and the automatic
 * conversion of an integer to a string.
 *
 * The facts are the example, so MagicNumber is reported deliberately.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Facts {

    private Facts() {
    }

    /**
     * Prints various facts.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        // Strings can be concatenated into one long String
        System.out.println("We present the following facts for your "
                + "extracurricular edification:");

        System.out.println();

        // A String can contain numeric digits
        System.out.println("Letters in the Hawaiian alphabet: 12");

        // A numeric value can be concatenated to a String
        System.out.println("Dialing code for Antarctica: " + 672);

        int parachuteInvented = 1515;
        System.out.println("Year in which Leonardo da Vinci invented "
                + "the parachute: " + parachuteInvented);

        final int ketchupSpeed = 40;
        System.out.println("Speed of ketchup: " + ketchupSpeed + " km per year");
    }
}
