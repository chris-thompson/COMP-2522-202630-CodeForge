package ca.bcit.comp2522.sorting;

import java.util.Random;
import java.util.Scanner;

/**
 * Numbers.
 *
 * @author BCIT
 * @version 2026
 */
public final class Numbers {

    private Numbers() {
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        Integer[] intList;
        int size;
        Scanner scan = new Scanner(System.in);
        System.out.print("\nHow many integers do you want to sort? ");
        size = scan.nextInt();
        intList = new Integer[size];
        Random generator = new Random();
        for (int i = 0; i < size; i++) {
            intList[i] = generator.nextInt();
        }
        Sorting.insertionSort(intList);
        System.out.println("\nYour numbers in sorted order...");
        for (int i = 0; i < size; i++) {
            System.out.print(intList[i] + "  ");
        }
        System.out.println();
        scan.close();
    }
}
