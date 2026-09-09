package ca.bcit.comp2522.arrays;

import java.util.Scanner;

/**
 * Demonstrates array index processing.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class ReverseOrder {
    /**
     * How many numbers to read.
     */
    public static final int ARRAY_SIZE = 10;

    private ReverseOrder() {
    }

    /**
     * Scans a list of numbers from the user, storing them in an array, and then
     * prints them in the opposite order.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final double[] numbers = new double[ARRAY_SIZE];
        System.out.println("The size of the array: " + numbers.length);

        final Scanner scan = new Scanner(System.in);
        for (int index = 0; index < numbers.length; index++) {
            System.out.print("Enter a floating point number for index " + (index + 1) + ": ");
            numbers[index] = scan.nextDouble();
        }

        System.out.println("The numbers in reverse order:");
        for (int index = numbers.length - 1; index >= 0; index--) {
            System.out.print(numbers[index] + "  ");
        }

        scan.close();
    }
}
