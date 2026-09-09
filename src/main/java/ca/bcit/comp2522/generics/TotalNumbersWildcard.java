package ca.bcit.comp2522.generics;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Adds all Numbers or anything that extends Number!
 *
 * @author BCIT
 * @version 2026
 */
public final class TotalNumbersWildcard {

    /** Sample integers to total. */
    private static final Integer[] INTEGERS = {1, 2, 3, 4, 5};

    /** Sample doubles to total. */
    private static final Double[] DOUBLES = {1.1, 3.3, 5.5};

    /** A deliberately mixed array: some Integers, some Doubles. */
    private static final Number[] NUMBERS = {1, 2.4, 3, 4.1};

    private TotalNumbersWildcard() {
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
        System.out.printf("Total of the elements in integerList: %.0f\n\n", sum(integerList));

        ArrayList<Double> doubleList = new ArrayList<>();
        Collections.addAll(doubleList, DOUBLES);

        System.out.printf("doubleList contains: %s\n", doubleList);
        System.out.printf("Total of the elements in doubleList: %.1f\n\n", sum(doubleList));

        ArrayList<Number> numberList = new ArrayList<>();
        Collections.addAll(numberList, NUMBERS);

        System.out.printf("numberList contains: %s\n", numberList);
        System.out.printf("Total of the elements in numberList: %.1f\n", sum(numberList));
    }

    /**
     * Accepts a list of Number or anything that extends Number and returns the sum.
     *
     * @param list of Number
     * @return sum as a double
     */
    public static double sum(final ArrayList<? extends Number> list) {
        double total = 0;
        for (Number element : list) {
            total += element.doubleValue();
        }
        return total;
    }
}
