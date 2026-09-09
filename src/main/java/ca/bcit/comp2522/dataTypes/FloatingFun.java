package ca.bcit.comp2522.dataTypes;

/**
 * Demonstrates some floating point number properties.
 *
 * @author BCIT
 * @version 2026
 */
public final class FloatingFun {

    private FloatingFun() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {

        final double aValue = 1.0 / 0;
        System.out.println(aValue);

        final double anotherValue = -1.0 / 0;
        System.out.println(anotherValue);

        // This will throw an Arithmetic Exception
        // double yetAnotherValue = 0 / 0;
        // System.out.println(yetAnotherValue);
    }
}
