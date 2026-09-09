package ca.bcit.comp2522.controlStatements;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Demonstrates the use of a while loop for input validation.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class WinPercentage {

    private WinPercentage() { }

    /**
     * Computes the percentage of games won by a team.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final Scanner scan = new Scanner(System.in);
        final int numGames = 12;
        System.out.print("Enter the number of games won (0 to "
                + numGames + "): ");
        int won = scan.nextInt();

        while (won < 0 || won > numGames) {
            System.out.print("Invalid input. Please reenter: ");
            won = scan.nextInt();
        }

        double ratio = (double) won / numGames;

        NumberFormat fmt = NumberFormat.getPercentInstance();

        System.out.println();
        System.out.println("Winning percentage: " + fmt.format(ratio));

        scan.close();
    }
}
