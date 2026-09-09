package ca.bcit.comp2522.controlStatements;

import java.util.Scanner;

/**
 * Demonstrates the use of a do-while loop.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class ReverseNumber {

    private ReverseNumber() { }

    /**
     * Reverses the digits of an integer mathematically.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final Scanner scan = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scan.nextInt();

        /* Will this work for multiples of 10, i.e., numbers
           with trailing zeros? */
        int lastDigit;
        int reverse = 0;
        final int base = 10;
        do {
            lastDigit = number % base;
            reverse = (reverse * base) + lastDigit;
            number = number / base;
        } while (number > 0);

        System.out.println("That number reversed is " + reverse);

        scan.close();
    }
}
