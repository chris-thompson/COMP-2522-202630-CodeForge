package ca.bcit.comp2522.enums;

/**
 * Demonstrates the use of a full enumerated type.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class SeasonTester {

    private SeasonTester() {
    }

    /**
     * Iterates through the values of the Season enumerated type.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        for (Season time : Season.values()) {
            System.out.println(time + "\t" + time.getSpan());
        }
    }
}
