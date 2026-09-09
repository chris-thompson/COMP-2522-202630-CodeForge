package ca.bcit.comp2522.maps.dice;

import ca.bcit.comp2522.dice.Die;

import java.util.HashMap;
import java.util.Map;

/**
 * Counter.
 *
 * @author BCIT
 * @version 2026
 */
public final class Counter {

    private final Die unbiasedDie;
    private final HashMap<Integer, Integer> frequencyTable;

    /**
     * Constructor for objects of type Counter.
     */
    public Counter() {
        unbiasedDie = new Die();
        frequencyTable = new HashMap<>();
    }

    /**
     * Drives the program.
     *
     * @param args not used
     */
    public static void main(final String[] args) {
        Counter counter = new Counter();
        final int aVerylargeNumber = 1_000_000;
        counter.roll(aVerylargeNumber);
        System.out.println(counter);
    }

    /**
     * Rolls the Die the specified number of times.
     *
     * @param numberOfRolls an int
     */
    public void roll(final int numberOfRolls) {
        for (int i = 0; i < numberOfRolls; ++i) {
            int newRoll = unbiasedDie.roll();
            if (frequencyTable.get(newRoll) == null) {
                frequencyTable.put(newRoll, 1);
            } else {
                frequencyTable.put(newRoll, frequencyTable.get(newRoll) + 1);
            }
        }
    }

    /**
     * Returns a description of this Counter.
     *
     * @return description as a String
     */
    @Override
    public String toString() {
        StringBuilder table = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : frequencyTable.entrySet()) {
            table.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return table.toString();
    }

}
