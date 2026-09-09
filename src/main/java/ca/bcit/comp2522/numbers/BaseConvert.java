package ca.bcit.comp2522.numbers;

import java.util.Scanner;

/**
 * Converts a base 10 number into another base, by hand.
 *
 * The algorithm is repeated division. To write a number in base b, divide it
 * by b: the remainder is the last digit, and the quotient is the number that
 * remains to be converted. Repeat until the quotient reaches zero, and the
 * digits come out in reverse order, which is why they are prepended rather
 * than appended below.
 *
 * The original version of this file handled exactly four digits, because it
 * had four copies of the same two lines written out one after another. Compare
 * it with the loop here: the loop is shorter, it handles a number of any size,
 * and there is only one place to fix if the algorithm turns out to be wrong.
 * When you find yourself copying and pasting a pair of lines, that is a loop
 * asking to be written.
 *
 * @author BCIT
 * @version 2026
 */
public final class BaseConvert {

    /** The base we are converting from. */
    private static final int DECIMAL = 10;

    /** The lowest base this program accepts. */
    private static final int MIN_BASE = 2;

    /** The highest base this program accepts. */
    private static final int MAX_BASE = 9;

    private BaseConvert() {
    }

    /**
     * Converts a non-negative base 10 number into the given base.
     *
     * Preconditions: number must not be negative, and base must be between
     * MIN_BASE and MAX_BASE inclusive. Exceptions are a Week 09 topic, so this
     * method does not throw; a base outside the range is clamped to DECIMAL
     * and a negative number is treated as zero.
     *
     * @param number the value to convert, in base 10
     * @param base   the base to convert it into
     * @return the number written in the requested base, as a String
     */
    public static String toBase(final int number, final int base) {

        if (base < MIN_BASE || base > MAX_BASE) {
            return String.valueOf(number);
        }

        if (number <= 0) {
            return "0";
        }

        final StringBuilder digits = new StringBuilder();
        int remaining = number;

        while (remaining > 0) {

            // The remainder is the next digit, working right to left, so it
            // goes on the front of what we have built so far.
            digits.insert(0, remaining % base);
            remaining = remaining / base;
        }

        return digits.toString();
    }

    /**
     * Asks for a base and a number, then prints the conversion.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final Scanner scan = new Scanner(System.in);

        System.out.println("Base Conversion Program");
        System.out.print("Please enter a base (" + MIN_BASE + "-" + MAX_BASE + "): ");
        final int base = scan.nextInt();

        System.out.print("Please enter a base 10 number to convert: ");
        final int number = scan.nextInt();

        System.out.println(number + " in base " + base + " is " + toBase(number, base));

        scan.close();
    }
}
