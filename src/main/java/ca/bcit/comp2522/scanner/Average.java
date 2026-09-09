package ca.bcit.comp2522.scanner;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Demonstrates the use of a while loop, a sentinel value, and a running sum.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Average {

    private Average() { }

    /**
     * Computes the average of a set of values entered by the user. The running
     * sum is printed as the numbers are entered.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        System.out.print("Enter an integer (0 to quit): ");
        final Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();

        int sum = 0;
        int count = 0;

        while (value != 0) { // sentinel value of 0 to terminate loop
            count++;

            sum += value;
            System.out.println("The sum so far is " + sum);

            System.out.print("Enter an integer (0 to quit): ");
            value = scan.nextInt();
        }

        System.out.println();
        final double average;
        if (count == 0) {
            System.out.println("No values were entered.");
        } else {
            average = (double) sum / count;

            DecimalFormat fmt = new DecimalFormat("0.###");
            System.out.println("The average is " + fmt.format(average));
        }

        scan.close();
    }
}
