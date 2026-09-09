package ca.bcit.comp2522.sorting;

import java.util.ArrayList;

/**
 * Sort2 uses a Comparator (neato!).
 *
 * @author BCIT
 * @version 2026
 */
public class Sort2 {

    /** The times the demonstration sorts. Deliberately out of order. */
    private static final SimpleTime[] SAMPLE_TIMES = {
        new SimpleTime(6, 24, 34),
        new SimpleTime(6, 5, 34),
        new SimpleTime(12, 14, 58),
        new SimpleTime(6, 24, 22),
    };

    /**
     * Prints the sample times, then prints them again in sorted order.
     *
     * This implementation sorts with a TimeComparator. A subclass wanting a
     * different order should override this method and supply its own.
     */
    public void printElements() {
        final java.util.List<SimpleTime> list = new ArrayList<>();
        java.util.Collections.addAll(list, SAMPLE_TIMES);

        System.out.printf("Unsorted array elements:%n%s%n", list);
        list.sort(new TimeComparator());
        System.out.printf("Sorted list elements:%n%s%n", list);
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        Sort2 sort2 = new Sort2();
        sort2.printElements();
    }
}
