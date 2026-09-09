package ca.bcit.comp2522.numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Demonstrates why money must not be stored in a double, and what to use.
 *
 * A double stores a number in binary, and most decimal fractions have no exact
 * binary representation — in the same way that one third has no exact decimal
 * representation. 0.1 is not really 0.1; it is the nearest double to 0.1. Add
 * a few of those together and the error becomes visible.
 *
 * This is not a bug in Java. Every language that uses IEEE 754 floating point
 * behaves this way, Python included. It is a property of the representation.
 *
 * BigDecimal stores the digits and the position of the decimal point, so it
 * represents decimal values exactly. The costs are that it is slower, that you
 * lose the arithmetic operators and call add and multiply instead, and that
 * you must say how to round. For money, that is a bargain.
 *
 * One rule matters more than the rest: build a BigDecimal from a STRING, not
 * from a double. new BigDecimal(0.1) faithfully copies the error that is
 * already in the double. new BigDecimal("0.1") does not.
 *
 * @author BCIT
 * @version 2026
 */
public final class BigDecimalMoney {

    /** How many decimal places money is kept to. */
    private static final int CENTS = 2;

    /** Sales tax rate applied in the example. */
    private static final String TAX_RATE = "0.12";

    /** The value a tenth plus a fifth ought to come to, held exactly. */
    private static final BigDecimal THREE_TENTHS_EXACTLY = new BigDecimal("0.3");

    /** One tenth, as a double, so its inexactness can be shown. */
    private static final double ONE_TENTH = 0.1;

    /** Three tenths, as a double, for the comparison that surprisingly fails. */
    private static final double THREE_TENTHS_INEXACT = 0.3;

    private BigDecimalMoney() {
    }

    /**
     * Shows that a double cannot hold an exact decimal fraction.
     */
    private static void showTheProblem() {

        final double tenCents = 0.1;
        final double twentyCents = 0.2;

        // Prints 0.30000000000000004, not 0.3.
        System.out.println("0.1 + 0.2 as doubles = " + (tenCents + twentyCents));

        // And so this test, which looks obviously true, is false.
        System.out.println("0.1 + 0.2 == 0.3 is "
                + (tenCents + twentyCents == THREE_TENTHS_INEXACT));

        // Add ten cents ten times and you should have one dollar exactly.
        double runningTotal = 0.0;
        final int additions = 10;
        for (int i = 0; i < additions; i++) {
            runningTotal += tenCents;
        }
        System.out.println("ten times ten cents, as a double = " + runningTotal);
        System.out.println("is that exactly 1.00? " + (runningTotal == 1.0));
    }

    /**
     * Shows BigDecimal getting the same arithmetic right.
     */
    private static void showTheFix() {

        // Built from Strings, so the values are exactly what they look like.
        final BigDecimal a = new BigDecimal("0.1");
        final BigDecimal b = new BigDecimal("0.2");

        // No + operator. BigDecimal objects are immutable, so add returns a
        // new object rather than changing either operand.
        System.out.println("0.1 + 0.2 as BigDecimals = " + a.add(b));

        // compareTo, not equals. equals also compares the scale, so it says
        // that 0.10 and 0.1 are different numbers. compareTo compares value.
        System.out.println("does it equal 0.3? "
                + (a.add(b).compareTo(THREE_TENTHS_EXACTLY) == 0));

        // This is the danger. Built from a double, the error comes along too.
        System.out.println("new BigDecimal(0.1)   = " + new BigDecimal(ONE_TENTH));
        System.out.println("new BigDecimal(\"0.1\") = " + new BigDecimal("0.1"));
    }

    /**
     * Works out a small invoice, and formats it for a human to read.
     */
    private static void showAnInvoice() {

        final BigDecimal price = new BigDecimal("19.99");
        final BigDecimal quantity = new BigDecimal("3");
        final BigDecimal subtotal = price.multiply(quantity);

        // Rounding is not optional: you must say which rule to use. HALF_UP is
        // the rule you were taught at school, and the one most invoices use.
        final BigDecimal tax = subtotal.multiply(new BigDecimal(TAX_RATE))
                .setScale(CENTS, RoundingMode.HALF_UP);

        final BigDecimal total = subtotal.add(tax);

        // DecimalFormat handles presentation. Note the division of labour:
        // BigDecimal is responsible for the arithmetic being right,
        // DecimalFormat only for how the answer is written down.
        final DecimalFormat money = new DecimalFormat("$#,##0.00");
        System.out.println("subtotal: " + money.format(subtotal));
        System.out.println("tax:      " + money.format(tax));
        System.out.println("total:    " + money.format(total));
    }

    /**
     * Shows the floating point problem, then solves it with BigDecimal.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        System.out.println("--- the problem, and what it costs you ---");
        showTheProblem();

        System.out.println("--- the fix ---");
        showTheFix();

        System.out.println("--- a small invoice ---");
        showAnInvoice();
    }
}
