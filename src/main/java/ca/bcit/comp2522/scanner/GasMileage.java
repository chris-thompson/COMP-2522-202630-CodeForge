package ca.bcit.comp2522.scanner;

import java.util.Scanner;

/**
 * Demonstrates the use of the Scanner class to read numeric data.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class GasMileage {

    private GasMileage() {
    }

    /**
     * Calculates fuel efficiency based on values entered by the user.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        System.out.print("Enter the number of miles: ");
        final Scanner scan = new Scanner(System.in);
        final int miles = scan.nextInt();

        System.out.print("Enter the gallons of fuel used: ");
        final double gallons = scan.nextDouble();

        final double mpg = miles / gallons;
        System.out.println("Miles Per Gallon: " + mpg);

        scan.close();
    }
}
