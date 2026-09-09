package ca.bcit.comp2522.generics;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Adding numbers.
 *
 * @author BCIT
 * @version 2026
 */
public final class TotalNumbers {
    /** A deliberately mixed array: some Integers, some Doubles. */
    private static final Number[] NUMBERS = {1, 2.4, 3, 4.1};

    private TotalNumbers() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        ArrayList<Number> numberList = new ArrayList<>();
        Collections.addAll(numberList, NUMBERS);

        System.out.printf("numberList contains: %s\n", numberList);
        System.out.printf("Total of the elements in numberList: %.1f\n", sum(numberList));
    }

    /**
     * Accepts a list of Number and returns the sum.
     *
     * @param list of Number
     * @return sum as a double
     */
    public static double sum(final ArrayList<Number> list) {
        double total = 0;
        for (Number element : list) {
            total += element.doubleValue();
        }
        return total;
    }
}
