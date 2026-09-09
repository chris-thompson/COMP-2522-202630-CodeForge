package ca.bcit.comp2522.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Sort1 uses the sort method in Collections.
 *
 * @author BCIT
 * @version 2026
 */
public class Sort1 {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades" };

    /**
     * Prints the elements in a sorted list.
     */
    public void printElements() {
        List<String> list = Arrays.asList(SUITS);
        System.out.printf("Unsorted array elements:%n%s%n", list);
        Collections.sort(list);
        System.out.printf("Sorted array elements:%n%s%n", list);
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        Sort1 sort1 = new Sort1();
        sort1.printElements();
    }
}
