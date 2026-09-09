package ca.bcit.comp2522.inheritance.orderOfInitialization;

/**
 * BeetleDriver demonstrates what happens when we declare but don't initialize.
 *
 * @author BCIT
 * @version 2026
 */
public final class BeetleDriver {

    private BeetleDriver() {
    }

    /**
     * Drives the program.
     * <p>
     * What if we declare a variable of type Beetle without
     * actually initializing a Beetle object?
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        System.out.println("Started program");
        // Beetle beetle;
        Beetle beetle = new Beetle();
        System.out.println(beetle);
    }
}
