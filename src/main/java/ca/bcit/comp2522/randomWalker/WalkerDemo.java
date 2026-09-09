package ca.bcit.comp2522.randomWalker;

import java.util.Scanner;

/**
 * WalkerDemo.
 *
 * @author BCIT
 * @version 2026
 */
public final class WalkerDemo {

    /** How many steps the scripted walkers take. */
    private static final int DEMO_STEPS = 5;

    private WalkerDemo() {
    }

    /**
     * Walks a RandomWalker a few steps, printing it as it goes.
     *
     * @param walker the walker to move
     * @param steps  how many steps to take
     */
    private static void walk(final RandomWalker walker, final int steps) {

        System.out.println(walker);

        for (int i = 0; i < steps; i++) {
            walker.takeStep();
            System.out.println(walker);
            System.out.println("Max distance = " + walker.getMaximumDistance());
        }
    }

    /**
     * Builds a RandomWalker from numbers typed by the user.
     *
     * @param scan the Scanner to read from
     * @return a new RandomWalker
     */
    private static RandomWalker readWalker(final Scanner scan) {

        System.out.println("Please enter the maximum number of steps");
        final int userMax = scan.nextInt();

        System.out.println("Please enter the boundary size");
        final int userBoundary = scan.nextInt();

        return new RandomWalker(userMax, userBoundary);
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {

        final int maximumSteps = 10;
        final int boundary = 5;
        final RandomWalker testWalker = new RandomWalker(maximumSteps, boundary);

        final Scanner scan = new Scanner(System.in);
        final RandomWalker userWalker = readWalker(scan);

        walk(testWalker, DEMO_STEPS);
        walk(userWalker, DEMO_STEPS);

        // This one walks until it hits its boundary rather than a fixed number
        // of steps, so the number of lines it prints is different every run.
        final int moreSteps = 200;
        final int anotherBoundary = 10;
        final RandomWalker anotherWalker =
                new RandomWalker(moreSteps, anotherBoundary);

        System.out.println(anotherWalker);
        anotherWalker.walk();
        System.out.println(anotherWalker);
        System.out.println("Max distance = " + anotherWalker.getMaximumDistance());

        scan.close();
    }
}
