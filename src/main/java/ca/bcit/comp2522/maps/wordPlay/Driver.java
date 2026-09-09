package ca.bcit.comp2522.maps.wordPlay;

import java.util.Scanner;

/**
 * Driver.
 *
 * @author BCIT
 * @version 2026
 */
public final class Driver {

    private Driver() {
    }

    /**
     * Drives the program.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        MapTester letterCount = new MapTester();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a sentence");
        String sentence = scan.nextLine();
        letterCount.countLetters(sentence);
        scan.close();
    }

}
