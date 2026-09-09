package ca.bcit.comp2522.operators;

/**
 * Demonstrates the prefix and postfix forms of ++ and --.
 *
 * Both forms change the variable by one. They differ in what the EXPRESSION
 * evaluates to, which only matters when you use the result of the expression
 * for something.
 *
 *   ++count   prefix:  add one first, then hand back the new value
 *   count++   postfix: hand back the old value first, then add one
 *
 * As a statement on a line of its own, count++ and ++count are identical and
 * you should write whichever reads better. The difference only appears when
 * the increment is buried inside a larger expression, which is exactly where
 * you should not be putting it.
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
public final class IncrementDecrement {

    private IncrementDecrement() {
    }

    /**
     * Shows the difference between the prefix and postfix forms.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        // Prefix: count becomes 6, and the expression is also 6.
        int count = 5;
        int result = ++count;
        System.out.println("prefix:  count = " + count + ", result = " + result);

        // Postfix: count becomes 6, but the expression was 5.
        count = 5;
        result = count++;
        System.out.println("postfix: count = " + count + ", result = " + result);

        // On a line by itself there is no difference at all. Both of these
        // leave count at 7, and neither is faster than the other.
        count = 5;
        count++;
        ++count;
        System.out.println("after count++ and ++count: " + count);

        // The decrement operator works exactly the same way in reverse.
        int lives = 3;
        System.out.println("lives-- gives " + lives-- + ", leaving " + lives);

        // This is the reason this file exists. Applying ++ twice to the same
        // variable inside one expression is legal Java, and the language does
        // define what it means, but no reader can work it out at a glance and
        // in most other languages it is genuinely undefined. Never write it.
        // If you want to add two to a variable, write count += 2.
        int confusing = 5;
        confusing = confusing++ + ++confusing;
        System.out.println("do not write this: " + confusing);

        // Write this instead. It says what it means.
        int clear = 5;
        clear += 2;
        System.out.println("write this: " + clear);
    }
}
