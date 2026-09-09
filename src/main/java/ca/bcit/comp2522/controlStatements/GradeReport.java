package ca.bcit.comp2522.controlStatements;

import java.util.Scanner;

/**
 * Demonstrates the use of a switch statement.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class GradeReport {

    /**
     * Reduces the grade by a factor of 10.
     */
    public static final int BIN_SIZE = 10;

    private GradeReport() { }

    /**
     * Cues the user to enter a grade and prints comments accordingly.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final int perfect = 10;
        final int average = 7;

        final Scanner scan = new Scanner(System.in);

        System.out.print("Enter a numeric grade (0 to 100): ");
        final int grade = scan.nextInt();

        final int category = grade / BIN_SIZE;

        System.out.print("That grade is ");

        switch (category) {
            case perfect -> System.out.println("a perfect score. Well done.");
            case perfect - 1 -> System.out.println("well above average. Excellent.");
            case average + 1 -> System.out.println("above average. Nice job.");
            case average -> System.out.println("average.");
            case average - 1 -> {
                System.out.println("below average. You should see the");
                System.out.println("instructor to clarify the material "
                        + "presented in class.");
            }
            default -> System.out.println("not passing.");
        }

        scan.close();
    }
}
