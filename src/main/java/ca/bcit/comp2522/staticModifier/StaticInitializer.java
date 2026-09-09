package ca.bcit.comp2522.staticModifier;

import java.time.LocalDate;

/**
 * Demonstrates static initialization blocks.
 *
 * @author BCIT
 * @version 2026
 */
public final class StaticInitializer {

    /* What does this do? */
    private static LocalDate currentDate = null;

    static {
        System.out.println("Inside a static block.");
        System.out.println("This is executed BEFORE the constructor!");
        System.out.println(currentDate);
    }

    /**
     * Constructs an object of type StaticInitializer.
     */
    public StaticInitializer() {
        System.out.println("Constructing the object.");
        currentDate = this.getCurrentDate();
        System.out.println(currentDate);
    }

    /**
     * Returns a value.
     *
     * @return an int
     */
    public LocalDate getCurrentDate() {
        System.out.println("Entering method getCurrentDate");
        return LocalDate.now();
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        StaticInitializer staticInitializer = new StaticInitializer();
        System.out.println(staticInitializer); // What is being printed here?!
    }
}
