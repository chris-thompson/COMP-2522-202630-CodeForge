package ca.bcit.comp2522.numbers;

import java.math.BigInteger;

/**
 * Demonstrates BigInteger, which holds an integer of any size at all.
 *
 * A long overflows at 20! — the factorial of 20 is the largest that fits in
 * 64 bits. BigInteger has no fixed width, so it just keeps going. The cost is
 * that you lose the arithmetic operators: there is no + or * for objects in
 * Java, so you call add() and multiply() instead.
 *
 * @author BCIT
 * @version 2026
 */
public final class BigFactorial {

    private BigFactorial() {

    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final int upperBound = 15;
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 2; i <= upperBound; ++i) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            System.out.println(factorial);
        }
    }
}
