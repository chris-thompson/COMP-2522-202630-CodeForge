package ca.bcit.comp2522.dice;

/**
 * Demonstrates the creation and use of a user-defined class.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class RollingDice {

    private RollingDice() { }

    /**
     * Driver program creates two Die objects and rolls them.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final Die die1 = new Die();
        final Die die2 = new Die();

        die1.roll();
        die2.roll();
        System.out.println("Die One: " + die1 + ", Die Two: " + die2);

        die1.roll();
        final int newFace = 4;
        die2.setFaceValue(newFace);
        System.out.println("Die One: " + die1 + ", Die Two: " + die2);

        int sum = die1.getFaceValue() + die2.getFaceValue();
        System.out.println("Sum: " + sum);

        sum = die1.roll() + die2.roll();
        System.out.println("Die One: " + die1 + ", Die Two: " + die2);
        System.out.println("New sum: " + sum);

        System.out.println(die1);
        System.out.println(die2);
    }
}
