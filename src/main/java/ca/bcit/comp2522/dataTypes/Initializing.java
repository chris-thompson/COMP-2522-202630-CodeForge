package ca.bcit.comp2522.dataTypes;

/**
 * Demonstrates declaration and initialization.
 * Local variables must be initialized!
 *
 * @author BCIT
 * @version 2026
 */
public final class Initializing {

    // What happens if we take away "static"?
    private static final double HOURLY_WAGE = 15.50;

    private Initializing() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        // double hourlyWage;
        // System.out.println(hourlyWage);

        System.out.println(HOURLY_WAGE);
    }
}
