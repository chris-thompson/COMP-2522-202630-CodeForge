package ca.bcit.comp2522.dataTypes;

/**
 * Demonstrates widening conversion and promotion, both of which are automatic.
 *
 * A conversion changes a VALUE from one type to another. It does not change
 * the type of any variable, and it does not alter data already stored
 * anywhere: it produces a converted value for the expression it appears in.
 *
 * WIDENING moves to a type that can hold everything the old one could:
 *
 *     byte -&gt; short -&gt; int -&gt; long -&gt; float -&gt; double
 *     char -&gt; int  -&gt; long -&gt; float -&gt; double
 *
 * Java performs a widening for you, without being asked, because the magnitude
 * of the value cannot be lost. Precision is a different matter, as the long to
 * float case below shows.
 *
 * PROMOTION is widening that happens automatically inside an expression when
 * the operands have different types. The narrower operand is widened to match
 * the wider one, and the result has the wider type.
 *
 * The single most common surprise in this course lives here: if BOTH operands
 * of / are int, Java uses integer division and throws the remainder away, and
 * it does that before any assignment happens. See Narrowing for the other half
 * of the story.
 *
 * @author BCIT
 * @version 2026
 */
public final class Widening {

    private Widening() {
    }

    /**
     * Demonstrates automatic widening and promotion in expressions.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final byte smallValue = 127;

        // No cast needed in either direction along the widening chain.
        final int widerType = smallValue;
        final double widerStill = widerType;
        System.out.println("byte " + smallValue + " -> int " + widerType
                + " -> double " + widerStill);

        // A float has 32 bits, of which only 24 hold significant digits; a
        // long has 64, all significant. So long to float is a widening by the
        // rules, and it still cannot represent this value exactly.
        final long preciseValue = 123456789L;
        final float asFloat = preciseValue;
        System.out.println("long  " + preciseValue);
        System.out.println("float " + (long) asFloat + "   <- not the same number");

        final int wholeNumber = 7;
        final double fraction = 2.0;

        // Mixed types, so the int is promoted to double and the answer is 3.5.
        System.out.println("7 / 2.0 = " + (wholeNumber / fraction));

        // Both operands are int, so integer division happens FIRST and the
        // remainder is gone before the double ever sees it.
        final double surprising = wholeNumber / 2;
        System.out.println("7 / 2 stored in a double = " + surprising);

        // Cast one operand first to get what you probably meant.
        final double corrected = (double) wholeNumber / 2;
        System.out.println("(double) 7 / 2 = " + corrected);

        // char is an integer type, so it promotes to int in arithmetic.
        final char letter = 'A';
        System.out.println("'A' + 1 = " + (letter + 1) + ", as a char: "
                + (char) (letter + 1));
    }
}
