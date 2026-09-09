package ca.bcit.comp2522.controlStatements;

import java.util.Scanner;

/**
 * Demonstrates the use of an if statement.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Age {

    /**
     * Age of majority.  Person is minor if age < AGE_OF_MAJORITY
     */
    public static final int AGE_OF_MAJORITY = 19;


    private Age() { }

    /**
     * Reads the user's age and prints comments accordingly.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final Scanner scan = new Scanner(System.in);

        System.out.print("Enter your age: ");
        final int age = scan.nextInt();

        System.out.println("You entered: " + age);

        if (age < AGE_OF_MAJORITY) {
            System.out.println("Youth is a wonderful thing. Enjoy.");
        }

        System.out.println("Age is a state of mind.");

        scan.close();
    }
}
