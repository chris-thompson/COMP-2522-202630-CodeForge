package ca.bcit.comp2522.strings;

import java.util.Scanner;

/**
 * FunWithStrings.
 *
 * @author BCIT
 * @version 2026
 */
public final class FunWithStrings {

    private FunWithStrings() {

    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {

        final Scanner titleScanner = new Scanner(System.in);
        System.out.print("Enter the name of your favourite book: ");

        final String userInput = titleScanner.nextLine();
        // userInput = titleScanner.next();
        System.out.println(userInput);

        System.out.println("The title is " + userInput.length() + " characters long");
        userInput.toUpperCase();
        System.out.println(userInput);

        final String upperCaseUserInput = userInput.toUpperCase();
        System.out.println("User input in upper case: " + upperCaseUserInput);

        final String trimmedUserInput = userInput.trim();
        System.out.println("Trimmed user input: " + trimmedUserInput);
        System.out.println("Trimmed user input length : " + trimmedUserInput.length());

        String formattedOutput = userInput.trim();
        formattedOutput = formattedOutput.toLowerCase();
        final int length = formattedOutput.length();
        final String firstLetter = formattedOutput.substring(0, 1).toUpperCase();
        final String finalLetter = formattedOutput.substring(length - 1, length).toUpperCase();
        formattedOutput = formattedOutput.substring(1, length - 1);
        System.out.println(firstLetter + formattedOutput + finalLetter);

    }

}
