package ca.bcit.comp2522.exceptions;

/**
 * This is NOT how we want to deal with Exceptions. This approach
 * is not Java style (LBYL).  This is Pythonic (EAFP).
 *
 * @author BCIT
 * @version 2026
 */
public final class DontDoThis {

    private DontDoThis() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        String hello = "Blue";

        // This makes Java developers' eyes bleed, but it is Pythonic.
        try {
            int index = 0;
            while (true) {
                System.out.println(hello.charAt(index));
                index++;
            }
        // Checkstyle reports "Catching 'Exception' is not allowed" on the line
        // below, and Checkstyle is right. This violation is left in place on
        // purpose: the file exists to show you the thing you must not do, and
        // seeing the tool catch it is the point. Using an exception as a loop
        // exit hides every other bug that could occur inside the try block.
        } catch (Exception e) {
            System.out.println("This is terrible. Don't do this.");
        }
    }
}
