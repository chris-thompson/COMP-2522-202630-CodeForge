package ca.bcit.comp2522.controlStatements;

import java.util.Scanner;

/**
 * Demonstrates the use of nested while loops. Also demonstrates while loop with
 * compound condition.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class PalindromeTester {

    private PalindromeTester() { }

    /**
     * Tests Strings to see if they are palindromes.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        String str;
        String another = "y";
        final Scanner scan = new Scanner(System.in);

        while (another.equalsIgnoreCase("y")) { // allows y or Y

            System.out.println("Enter a potential palindrome:");
            str = scan.nextLine();

            int left = 0;
            int right = str.length() - 1;

            while (left < right && str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            }

            System.out.println();

            if (left < right) {
                System.out.println("That string is NOT a palindrome.");
            } else {
                System.out.println("That string IS a palindrome.");
            }

            System.out.println();
            System.out.print("Test another palindrome (y/n)? ");
            another = scan.nextLine();
        }

        scan.close();
    }
}
