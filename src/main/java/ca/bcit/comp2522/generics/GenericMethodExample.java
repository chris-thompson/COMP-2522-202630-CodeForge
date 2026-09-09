package ca.bcit.comp2522.generics;

/**
 * Demonstrate how to create and use a static generic method.
 *
 * @author BCIT
 * @version 2026
 */
public final class GenericMethodExample {

    /** Sample integers, chosen so the largest is not the first argument. */
    private static final int FIRST_INT = 3;

    /** Second sample integer. */
    private static final int SECOND_INT = 4;

    /** Third sample integer, and the largest of the three. */
    private static final int THIRD_INT = 5;

    /** Sample doubles, chosen so the largest is in the middle. */
    private static final double FIRST_DOUBLE = 6.6;

    /** Second sample double, and the largest of the three. */
    private static final double SECOND_DOUBLE = 8.8;

    /** Third sample double. */
    private static final double THIRD_DOUBLE = 7.7;

    /** Sample words, compared alphabetically rather than numerically. */
    private static final String FIRST_WORD = "pear";

    /** Second sample word, and the alphabetically smallest. */
    private static final String SECOND_WORD = "apple";

    /** Third sample word. */
    private static final String THIRD_WORD = "orange";

    private GenericMethodExample() { }

    /**
     * Returns the maximum of the three elements.
     * @param x an  object of type T
     * @param y an  object of type T
     * @param z an  object of type T
     * @param <T> the data type
     * @return the 'maximum' of x, y, and z
     */
    public static <T extends Comparable<T>> T maximum(final T x, final T y, final T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {

        // The same method, called three times with three different types.
        // That is the whole point of a generic method: without it you would
        // need maximumInt, maximumDouble and maximumString, all identical
        // except for the word int, double or String.
        System.out.printf("Maximum of %d, %d and %d is %d%n%n",
                FIRST_INT, SECOND_INT, THIRD_INT,
                maximum(FIRST_INT, SECOND_INT, THIRD_INT));

        System.out.printf("Maximum of %.1f, %.1f and %.1f is %.1f%n%n",
                FIRST_DOUBLE, SECOND_DOUBLE, THIRD_DOUBLE,
                maximum(FIRST_DOUBLE, SECOND_DOUBLE, THIRD_DOUBLE));

        System.out.printf("Maximum of %s, %s and %s is %s%n",
                FIRST_WORD, SECOND_WORD, THIRD_WORD,
                maximum(FIRST_WORD, SECOND_WORD, THIRD_WORD));

        // This does not compile, and the error message is the lesson. All
        // three arguments must be the SAME T, and T must be Comparable to
        // itself. An int and a String have no common Comparable type.
        //     maximum(3, "hello", 7);
    }
}
