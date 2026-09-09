package ca.bcit.comp2522.generics;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Adds all numbers.  Or does it? Oh no!
 *
 * @author BCIT
 * @version 2026
 */
public final class TotalNumbersProblem {

    /** Sample integers to total. */
    private static final Integer[] INTEGERS = {1, 2, 3, 4};

    private TotalNumbersProblem() {
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, INTEGERS);

        System.out.printf("integerList contains: %s\n", integerList);
        // System.out.printf("Total of the elements in integerList: %.1f\n", sum(integerList));
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
