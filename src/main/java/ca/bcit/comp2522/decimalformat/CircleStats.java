package ca.bcit.comp2522.decimalformat;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Demonstrates the formatting of decimal values using the DecimalFormat class.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class CircleStats {

    private CircleStats() { }

    /**
     * Calculates the area and circumference of a circle given its radius.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the circle's radius: ");
        final int radius = scan.nextInt();

        final double area = Math.PI * Math.pow(radius, 2);
        final double circumference = 2 * Math.PI * radius;

        final DecimalFormat fmt = new DecimalFormat("0.00000");
        System.out.println("The circle's area: " + fmt.format(area));
        System.out.println("The circle's circumference: " + fmt.format(circumference));

        scan.close();
    }
}
