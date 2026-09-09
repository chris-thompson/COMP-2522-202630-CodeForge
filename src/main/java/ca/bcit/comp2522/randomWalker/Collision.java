package ca.bcit.comp2522.randomWalker;

/**
 * Collision.
 *
 * @author BCIT
 * @version 2026
 */
public final class Collision {

    private Collision() {
    }

    /**
     * Returns true if the two RandomWalkers occupy the same position.
     *
     * @param one a RandomWalker
     * @param two a RandomWalker
     * @return true if one and two occupy the same position else false
     */
    public static boolean samePosition(final RandomWalker one, final RandomWalker two) {
        return one.getxCoordinate() == two.getxCoordinate()
                && one.getyCoordinate() == two.getyCoordinate();

    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        final int boundary = 1_000_000; // neato!
        final int steps = 100_000;
        final int startingPositionX = 3;
        RandomWalker walkerOne = new RandomWalker(steps, boundary);
        walkerOne.setxCoordinate(startingPositionX);
        RandomWalker walkerTwo = new RandomWalker(steps, boundary);
        walkerTwo.setxCoordinate(-startingPositionX); // not as neat, still cool
        int collisions = 0;
        while (walkerOne.moreSteps() && walkerTwo.moreSteps()) {
            walkerOne.takeStep();
            walkerTwo.takeStep();
            if (samePosition(walkerOne, walkerTwo)) {
                collisions++;
                // Extra
                System.out.println("There was a collision at ("
                        + walkerOne.getxCoordinate() + ", "
                        + walkerTwo.getyCoordinate() + ")");

            }
        }
        System.out.println("There were " + collisions + " collisions");

    }

}
