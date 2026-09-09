package ca.bcit.comp2522.operators;

/**
 * Demonstrates the logical operators, and why &amp;&amp; is not the same as &amp;.
 *
 * Java has two families of operators that both look like "and" and "or":
 *
 *   &amp;&amp;  ||  !     logical, work on booleans, and SHORT-CIRCUIT
 *   &amp;   |   ^  ~  bitwise, work on the individual bits of integers
 *
 * Short-circuiting is the important one. In "a &amp;&amp; b", if a is false then the
 * whole expression must be false whatever b is, so Java does not evaluate b at
 * all. Likewise in "a || b", if a is true then b is skipped. This is not just
 * an optimisation: it is how you write a safe test, because it lets you check
 * that something is valid before you use it.
 *
 * Python note: &amp;&amp; is "and", || is "or", and ! is "not".
 *
 * A note on the Checkstyle report: this file is reported for MagicNumber, and
 * the violations are deliberate. Naming these literals would defeat the file's
 * purpose, because the literals ARE the subject. In code that does real work,
 * name your constants; in a file whose job is to show you what 2 + 3 * 4
 * evaluates to, "2" is not a magic number, it is the example.
 *
 * @author BCIT
 * @version 2026
 */
public final class LogicalOperators {

    private LogicalOperators() {
    }

    /**
     * Demonstrates short-circuit evaluation and bitwise operators.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final int total = 10;

        // Taken from args so that its value is genuinely unknown until the
        // program runs. Run with no command line arguments and it is zero.
        final int itemCount = args.length;

        // This is safe. itemCount is zero, so the left side is false, so the
        // division on the right is never evaluated. Swap the two halves around
        // and the program crashes with an ArithmeticException.
        if (itemCount != 0 && total / itemCount > 1) {
            System.out.println("The average is greater than one.");
        } else {
            System.out.println("No items, and no division was attempted.");
        }

        // || short-circuits the other way: the right side is skipped when the
        // left side is already true.
        final boolean cached = true;
        if (cached || total > 5) {
            System.out.println("Short-circuited before checking the total.");
        }

        // ! flips a boolean.
        final boolean finished = false;
        System.out.println("finished = " + finished + ", !finished = " + !finished);

        // The bitwise operators work on the bits of an integer. 12 is 1100 in
        // binary and 10 is 1010, so:
        //     1100 & 1010 = 1000 = 8    (a bit is set only if BOTH are set)
        //     1100 | 1010 = 1110 = 14   (set if EITHER is set)
        //     1100 ^ 1010 = 0110 = 6    (set if EXACTLY ONE is set)
        final int left = 12;
        final int right = 10;
        System.out.println("12 & 10 = " + (left & right));
        System.out.println("12 | 10 = " + (left | right));
        System.out.println("12 ^ 10 = " + (left ^ right));

        // Integer.toBinaryString lets you see what actually happened.
        System.out.println("12 is " + Integer.toBinaryString(left));
        System.out.println("10 is " + Integer.toBinaryString(right));
        System.out.println("12 & 10 is " + Integer.toBinaryString(left & right));

        // & and | also work on booleans, where they mean "and" and "or"
        // WITHOUT short-circuiting: both sides are always evaluated. That is
        // almost never what you want, and using them here is a classic bug.
        // Use && and || for booleans, every time.
        System.out.println("false & true = " + (false & true));
    }
}
