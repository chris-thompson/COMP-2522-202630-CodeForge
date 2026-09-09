package ca.bcit.comp2522.numbers;

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Demonstrates the use of the Math class to perform a calculation
 * based on user input. Illustrates import static.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Quadratic {

    private Quadratic() {
        // intentionally empty
    }

    /**
     * Determines the roots of a quadratic equation.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        // ax^2 + bx + c

        final Scanner scan = new Scanner(System.in);

        System.out.print("Enter the coefficient of x squared: ");
        final int a = scan.nextInt();

        System.out.print("Enter the coefficient of x: ");
        final int b = scan.nextInt();

        System.out.print("Enter the constant: ");
        final int c = scan.nextInt();

        // Uses the quadratic formula to compute the roots.
        // Assumes a positive discriminant.
        final int discFactor = 4;
        final double discriminant = pow(b, 2) - (discFactor * a * c);
        final double root1 = (-b + sqrt(discriminant)) / (2 * a);
        final double root2 = (-b - sqrt(discriminant)) / (2 * a);

        System.out.println("Root #1: " + root1);
        System.out.println("Root #2: " + root2);

        scan.close();
    }
}
