package ca.bcit.comp2522.randomWalker;

import java.util.Scanner;

/**
 * DrunkWalker.
 *
 * @author BCIT
 * @version 2026
 */
public final class DrunkWalker {

    private DrunkWalker() {
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the boundary (an int)");
        final int boundary = scan.nextInt();
        System.out.println("Enter the number of steps (an int)");
        final int steps = scan.nextInt();
        System.out.println("How many drunks should try? (an int)");
        final int drunks = scan.nextInt();

        int fallenDrunks = 0;

        for (int i = 0; i < drunks; i++) {
            RandomWalker drunk = new RandomWalker(steps, boundary);
            drunk.walk();
            if (!drunk.inBounds() && drunk.moreSteps()) {
                fallenDrunks++;
            }
        }
        System.out.println(fallenDrunks + " out of " + drunks
                + " drunks have fallen");
    }

}
