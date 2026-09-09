package ca.bcit.comp2522.numberformat;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Demonstrates the use of the while loop to deal with bad input.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Purchase {

    /**
     * 5% sales tax rate.
     */
    public static final double TAX_RATE = 0.05;

    private Purchase() {
    }

    /**
     * Calculates the final price of a purchased item using values entered by
     * the user.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        System.out.print("Enter the quantity: ");
        final Scanner scan = new Scanner(System.in);

        // HELPFUL LOOK AT THIS!
        // Skips non-int token and re-prompts for input
        while (!scan.hasNextInt()) {

            scan.next(); // Reads and removes the non-int token from the scanner
            System.out.print("The quantity must be an integer\nEnter the quantity: ");
        }
        final int quantity = scan.nextInt();

        System.out.print("Enter the unit price: ");

        // Skips non-int token and re-prompts for input
        while (!scan.hasNextDouble()) {

            scan.next(); // Clears the non-int token from the scanner
            System.out.print("The unit price must be a number\nEnter the unit price: ");
        }
        final double unitPrice = scan.nextDouble();

        final double subtotal = quantity * unitPrice;
        final double tax = subtotal * TAX_RATE;
        final double totalCost = subtotal + tax;

        // Prints output with appropriate formatting
        final NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
        System.out.println("Subtotal: " + fmt1.format(subtotal));

        final NumberFormat fmt2 = NumberFormat.getPercentInstance();
        System.out.println("Tax: " + fmt1.format(tax) + " at " + fmt2.format(TAX_RATE));
        System.out.println("Total: " + fmt1.format(totalCost));

        scan.close();
    }
}
