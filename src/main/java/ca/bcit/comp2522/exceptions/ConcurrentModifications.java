package ca.bcit.comp2522.exceptions;

import java.util.ArrayList;

/**
 * Demonstrates a ConcurrentModificationException.
 *
 * @author BCIT
 * @version 2026
 */
public final class ConcurrentModifications {

    private ConcurrentModifications() {
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);

        for (Integer integer : integers) {
            System.out.println(integer);
            integers.removeFirst(); // 🛑 NO!
        }

    }

}
