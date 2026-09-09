package ca.bcit.comp2522.dataTypes;

import java.util.Scanner;

/**
 * IntegerWrapper demonstrates some very useful methods
 * in the Integer wrapper class.
 *
 * @author BCIT
 * @version 2026
 */
public final class IntegerWrapper {

    private IntegerWrapper() { }

    /**
     * Drives the program.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        final int userInput = scanner.nextInt();

        System.out.println("You entered: " + userInput);
        System.out.println("Binary: " + Integer.toBinaryString(userInput));
        System.out.println("Octal: " + Integer.toOctalString(userInput));
        System.out.println("Hexadecimal: " + Integer.toHexString(userInput));

        System.out.println("Max Integer: " + Integer.MAX_VALUE);
        System.out.println("Min Integer: " + Integer.MIN_VALUE);

        System.out.println("Enter an integer: ");
        final String input1 = scanner.next();
        System.out.println("Enter an integer: ");
        final String input2 = scanner.next();

        System.out.println(input1 + " + " + input2 + " = "
                + (Integer.parseInt(input1) + Integer.parseInt(input2)));
        scanner.close();
    }
}
