package ca.bcit.comp2522.variableLength;

/**
 * Demonstrates the use of a variable length parameter list.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class VariableParameters {

    private VariableParameters() {
    }

    /**
     * Creates two Family objects using a constructor that accepts
     * a variable number of String objects as passByValue.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String... args) { // WOW SARAH YOU BLEW MY MIND TODAY!
        Family lewis = new Family("John", "Sharon", "Justin",
                "Kayla", "Nathan", "Samantha");

        Family camden = new Family("Stephen", "Annie", "Matt",
                "Mary", "Simon", "Lucy", "Ruthie", "Sam", "David");

        Family smith = new Family("Kayden");


        System.out.println(lewis);
        System.out.println(camden);
        System.out.println(smith);
    }
}
