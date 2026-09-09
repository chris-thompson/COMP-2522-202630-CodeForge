package ca.bcit.comp2522.interfaces;

import java.util.ArrayList;

/**
 * Sort2 uses a Comparator (neato!).
 *
 * @author BCIT
 * @version 2026
 */
public class SortingTime {

    /** The times the demonstration sorts. Deliberately out of order. */
    private static final Time[] SAMPLE_TIMES = {
        new Time(6, 24, 34),
        new Time(18, 14, 58),
        new Time(6, 5, 34),
        new Time(12, 14, 58),
        new Time(6, 24, 22),
    };

    /**
     * Prints the sample times, then prints them again in sorted order.
     *
     * This implementation sorts with a TimeComparator rather than with the
     * natural ordering of Time. A subclass wanting a different order should
     * override this method and pass a different Comparator.
     */
    public void printElements() {
        final java.util.List<Time> list = new ArrayList<>();
        java.util.Collections.addAll(list, SAMPLE_TIMES);

        System.out.println("Unsorted array elements");
        System.out.println(list);
        list.sort(new TimeComparator());
        System.out.println("Sorted array elements");
        System.out.println(list);
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        SortingTime sortingTime = new SortingTime();
        sortingTime.printElements();
    }
}
