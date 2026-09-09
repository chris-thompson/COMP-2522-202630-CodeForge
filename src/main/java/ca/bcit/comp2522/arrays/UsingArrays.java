package ca.bcit.comp2522.arrays;

import java.util.Arrays;

/**
 * Demonstrates some things we can do with the Java array.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public class UsingArrays {

    private final int[] intArray = {1, 2, 3, 4, 5, 6};
    private final double[] doubleArray = {8.4, 9.3, 0.2, 7.9, 3.4};
    private final int[] filledIntArray;
    private final int[] intArrayCopy;

    /**
     * Constructs an object of type UsingArrays.
     */
    public UsingArrays() {
        final int mediumSize = 10;
        filledIntArray = new int[mediumSize]; // create int array with 10 elements
        intArrayCopy = new int[intArray.length];

        final int luckySeven = 7;
        Arrays.fill(filledIntArray, luckySeven); // fill with 7s
        Arrays.sort(doubleArray); // sort doubleArray ascending

        System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final UsingArrays usingArrays = new UsingArrays();
        usingArrays.printArrays();
        usingArrays.printEquality();

        final int intTheMiddle = 5;
        int location = usingArrays.searchForInt(intTheMiddle);
        if (location >= 0) {
            System.out.printf("Found 5 at element %d in intArray\n", location);
        } else {
            System.out.println("5 not found in intArray");
        }

        final int intNotThere = 8763;
        location = usingArrays.searchForInt(intNotThere);
        if (location >= 0) {
            System.out.printf("Found 8763 at element %d in intArray\n", location);
        } else {
            System.out.println("8763 not found in intArray");
        }
    }

    /**
     * Prints the arrays.
     */
    public void printArrays() {
        System.out.print("doubleArray: ");
        for (double doubleValue : doubleArray) {
            System.out.printf("%.1f ", doubleValue);
        }

        System.out.print("\nintArray: ");
        for (int intValue : intArray) {
            System.out.printf("%d ", intValue);
        }

        System.out.print("\nfilledIntArray: ");
        for (int intValue : filledIntArray) {
            System.out.printf("%d ", intValue);
        }

        System.out.print("\nintArrayCopy: ");
        for (int intValue : intArrayCopy) {
            System.out.printf("%d ", intValue);
        }

        System.out.println("\n");
    }

    /**
     * Searches for the specified integer.
     * @param value the integer to find
     * @return the index, or -1 if not found
     */
    public int searchForInt(final int value) {
        return Arrays.binarySearch(intArray, value);
    }

    /**
     * Demonstrates the static equals method in the Arrays class.
     */
    public void printEquality() {
        boolean b = Arrays.equals(intArray, intArrayCopy);
        if (b) {
            System.out.printf("intArray %s intArrayCopy\n", "==");
        } else {
            System.out.printf("intArray %s intArrayCopy\n", "!=");
        }

        b = Arrays.equals(intArray, filledIntArray);
        if (b) {
            System.out.printf("intArray %s filledIntArray\n", "==");
        } else {
            System.out.printf("intArray %s filledIntArray\n", "!=");
        }
    }
}
