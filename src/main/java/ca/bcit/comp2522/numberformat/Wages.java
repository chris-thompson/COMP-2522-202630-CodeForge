package ca.bcit.comp2522.numberformat;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Demonstrates the use of NumberFormat and the if-else statement.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Wages {

    private Wages() { }

    /**
     * Cues the user for the numbers of hours worked and calculates wages.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final double hourlyRate = 8.25; // regular pay rate
        final double overtimeRate = hourlyRate * 1.5;
        final int standardWeek = 40; // standard hours in a work week

        System.out.print("Enter the number of hours worked: ");
        final Scanner scan = new Scanner(System.in);
        final int hours = scan.nextInt();

        double pay;
        if (hours > standardWeek) {
            pay = standardWeek * hourlyRate + (hours - standardWeek) * overtimeRate;
        } else {
            pay = hours * hourlyRate;
        }

        final NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println("Gross earnings: " + fmt.format(pay));

        scan.close();
    }
}
