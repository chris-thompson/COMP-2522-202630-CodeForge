package ca.bcit.comp2522.generics;

/**
 * Demonstrates the use of the Box class.
 *
 * @author BCIT
 * @version 2026
 */
public final class BoxDriver {

    private BoxDriver() {
    }

    /**
    * Drives the program.
    *
    * @param args command line arguments (unused)
    */
    public static void main(final String[] args) {
        final int anAutoBoxedInt = 10;
        Box<Integer> integerBox = new Box<>(anAutoBoxedInt);
        Box<String> stringBox = new Box<>("Hello World");

        System.out.println("Integer Value: " + integerBox.get());
        System.out.println("String Value: " + stringBox.get());
    }
}
