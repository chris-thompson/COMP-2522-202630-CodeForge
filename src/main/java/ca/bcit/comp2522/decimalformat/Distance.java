package ca.bcit.comp2522.decimalformat;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Distance.
 *
 * @author BCIT
 * @version 2026
 */
public final class Distance {

    private Distance() {

    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Enter the x and y coordinates of the 1st point separated by a space");
        final double x1 = scan.nextDouble();
        final double y1 = scan.nextDouble();
        System.out.println("Enter the x and y coordinates of the 2nd point separated by a space");
        final double x2 = scan.nextDouble();
        final double y2 = scan.nextDouble();

        final double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("The distance equals " + distance);

        final DecimalFormat formatter = new DecimalFormat("#.##");
        System.out.println(formatter.format(distance));

    }

}
