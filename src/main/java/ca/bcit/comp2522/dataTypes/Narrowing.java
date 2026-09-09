package ca.bcit.comp2522.dataTypes;

/**
 * Demonstrates narrowing conversion, which requires a cast.
 *
 * NARROWING moves to a type that may not be able to hold the value:
 *
 *     double -&gt; float -&gt; long -&gt; int -&gt; short -&gt; byte
 *
 * Java will not do this for you. You must write a CAST — the target type in
 * parentheses — to say, in effect, "I know this may lose data and I am doing
 * it deliberately." The cast is not a request for Java to be careful. It is
 * you taking responsibility for the result.
 *
 * Two things get lost, and they are different:
 *
 *   PRECISION, when a fractional part is discarded. A cast to an integer type
 *   TRUNCATES towards zero; it does not round. Use Math.round if you want
 *   rounding.
 *
 *   MAGNITUDE, when the value simply does not fit. The high bits are thrown
 *   away and whatever is left is reinterpreted, which can change the sign and
 *   produce a number with no relationship to the original.
 *
 * See Widening for the conversions Java performs automatically, and Overflow
 * for what happens when arithmetic runs off the end of a type.
 *
 * @author BCIT
 * @version 2026
 */
public final class Narrowing {

    private Narrowing() {
    }

    /**
     * Demonstrates truncation and loss of magnitude.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final double almostFour = 3.99;

        // This line will not compile, because Java will not silently discard
        // the fractional part for you:
        //     int truncated = almostFour;
        final int truncated = (int) almostFour;

        System.out.println("(int) 3.99       = " + truncated
                + "   <- truncated, not rounded");
        System.out.println("Math.round(3.99) = " + Math.round(almostFour));

        // Truncation towards zero, not downwards. Note what happens to the
        // negative value: it moves up, not down.
        final double negative = -3.99;
        System.out.println("(int) -3.99      = " + (int) negative);
        System.out.println("Math.floor(-3.99) = " + Math.floor(negative));

        // A byte holds -128 to 127. 300 does not fit, so the high bits are
        // discarded and what remains is reinterpreted. The compiler allowed it
        // only because the cast said you meant to.
        final int tooBig = 300;
        System.out.println("(byte) 300       = " + (byte) tooBig);

        // The same thing, far enough out to change the sign.
        final int wayTooBig = 200;
        System.out.println("(byte) 200       = " + (byte) wayTooBig);

        // Narrowing a char is how you get back from an int to a letter.
        final int letterCode = 66;
        System.out.println("(char) 66        = " + (char) letterCode);
    }
}
