package ca.bcit.comp2522.operators;

/**
 * Demonstrates operator precedence and associativity.
 *
 * Java has 38 operators, and when several appear in one expression the order
 * they are applied in is fixed by the language, not by the order you read them
 * in. That order is called precedence. The groups you will meet this week,
 * highest first:
 *
 *   1. ()             parentheses
 *   2. ++ -- (unary)  increment, decrement, unary minus, !
 *   3. * / %          multiplication, division, remainder
 *   4. + -            addition, subtraction
 *   5. &lt; &lt;= &gt; &gt;=      relational
 *   6. == !=          equality
 *   7. &amp;&amp;             logical and
 *   8. ||             logical or
 *   9. = += -= *= /=  assignment
 *
 * When two operators have the SAME precedence, associativity decides. Almost
 * everything in Java is left-associative, meaning it is applied left to right.
 * Assignment is the exception: it is right-associative.
 *
 * You are not expected to memorise this table. You are expected to know that
 * it exists, and to reach for parentheses whenever the answer is not obvious
 * at a glance. Parentheses cost nothing and are never wrong.
 *
 * A note on the Checkstyle report: this file is reported for MagicNumber, and
 * the violations are deliberate. Naming these literals would defeat the file's
 * purpose, because the literals ARE the subject. In code that does real work,
 * name your constants; in a file whose job is to show you what 2 + 3 * 4
 * evaluates to, "2" is not a magic number, it is the example.
 *
 * Checkstyle also reports InnerAssignment for "c = b = a = 5". It is right
 * that you should not write that in real code. It is here because it is the
 * clearest demonstration of right-associativity available.
 *
 * @author BCIT
 * @version 2026
 */
public final class OperatorPrecedence {

    private OperatorPrecedence() {
    }

    /**
     * Evaluates several expressions whose value depends on precedence.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        // Multiplication binds tighter than addition, so this is 2 + (3 * 4),
        // which is 14. It is not (2 + 3) * 4, which would be 20.
        System.out.println("2 + 3 * 4      = " + (2 + 3 * 4));
        System.out.println("(2 + 3) * 4    = " + ((2 + 3) * 4));

        // Same precedence, so left to right: (10 - 4) - 3, which is 3.
        System.out.println("10 - 4 - 3     = " + (10 - 4 - 3));

        // Division and remainder sit at the same level as multiplication.
        // This is ((100 / 10) % 7), which is 3.
        System.out.println("100 / 10 % 7   = " + (100 / 10 % 7));

        // Integer division truncates towards zero, it does not round. This is
        // 3, not 3.5 and not 4. It is the single most common surprise in this
        // course, and it happens because BOTH operands are int.
        System.out.println("7 / 2          = " + (7 / 2));

        // Make one operand a double and the whole expression is promoted.
        System.out.println("7 / 2.0        = " + (7 / 2.0));

        // The remainder operator keeps the sign of the left operand.
        System.out.println("-7 % 3         = " + (-7 % 3));
        System.out.println("7 % -3         = " + (7 % -3));

        // Relational operators are lower than arithmetic, so the arithmetic
        // happens first: (1 + 2) < (2 * 2), which is 3 < 4, which is true.
        System.out.println("1 + 2 < 2 * 2  = " + (1 + 2 < 2 * 2));

        // Assignment is right-associative, so this reads c = (b = (a = 5)).
        // All three variables end up holding 5.
        int a;
        int b;
        int c;
        c = b = a = 5;
        System.out.println("after c = b = a = 5, c is " + c);

        // The + operator is overloaded: it adds numbers, but as soon as one
        // side is a String it concatenates instead. Precedence still applies
        // left to right, which is why these two lines differ.
        System.out.println("\"sum: \" + 1 + 2 = " + "sum: " + 1 + 2);
        System.out.println("\"sum: \" + (1 + 2) = " + "sum: " + (1 + 2));
    }
}
