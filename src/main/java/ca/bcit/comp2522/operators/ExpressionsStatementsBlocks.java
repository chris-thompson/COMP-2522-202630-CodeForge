package ca.bcit.comp2522.operators;

/**
 * Demonstrates the difference between an expression, a statement, and a block.
 *
 * These three words get used loosely in conversation and precisely in the Java
 * Language Specification. The distinction is worth having straight, because
 * error messages use the precise meanings.
 *
 *   An EXPRESSION produces a value. 2 + 2 is an expression. So is
 *   count &lt; limit, and so is scan.nextInt(). Every expression has a type.
 *
 *   A STATEMENT performs an action. It ends with a semicolon. Most statements
 *   are built around an expression: an assignment statement evaluates the
 *   expression on the right and stores the result on the left.
 *
 *   A BLOCK is a group of statements wrapped in braces. A block is itself a
 *   statement, which is why you can put one anywhere a statement is allowed.
 *   A block also defines a SCOPE: a variable declared inside a block stops
 *   existing when the block ends.
 *
 * Python note: where Python uses indentation to mark a block, Java uses braces
 * and ignores your indentation completely. Indent anyway. The compiler does
 * not care and every human reader does.
 *
 * Checkstyle reports three things in this file and all three are deliberate:
 * MagicNumber, because the literals are the examples; InnerAssignment, for
 * the chained assignment that shows assignment is an expression; and
 * AvoidNestedBlocks, for the bare block that shows scope follows braces.
 * Do not write any of the three in code that has a job to do.
 *
 * @author BCIT
 * @version 2026
 */
public final class ExpressionsStatementsBlocks {

    private ExpressionsStatementsBlocks() {
    }

    /**
     * Demonstrates expressions, statements, blocks, and block scope.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        // An expression on its own is not a statement and will not compile:
        //     2 + 2;
        // Java rejects it because the value is computed and then thrown away,
        // which is almost always a mistake. Use the value for something.
        final int sum = 2 + 2;
        System.out.println("the expression 2 + 2 has the value " + sum);

        // An assignment is an expression as well as a statement: it produces
        // the value that was assigned. That is why chained assignment works.
        int x;
        int y;
        x = y = 9;
        System.out.println("x = " + x + ", y = " + y);

        // A block groups statements. This one is attached to an if.
        final int score = 88;
        if (score > 50) {
            final String grade = "pass";
            System.out.println("score " + score + " is a " + grade);
        }

        // The variable grade does not exist out here. It was declared inside
        // the block above, so it went out of scope when that block closed.
        // Uncommenting the next line produces "cannot find symbol".
        //     System.out.println(grade);

        // A bare block is legal on its own, with no if or loop attached. It is
        // rarely useful, but it shows that a block really is just a statement
        // and that scope really does follow the braces.
        {
            final int temporary = 42;
            System.out.println("inside a bare block, temporary = " + temporary);
        }

        // Declaring a variable with the same name is fine now, because the
        // previous one no longer exists.
        final int temporary = 7;
        System.out.println("outside it, a different temporary = " + temporary);

        // A loop body is a block too, so the loop counter and anything
        // declared inside the braces are gone once the loop finishes.
        for (int i = 0; i < 3; i++) {
            final int doubled = i * 2;
            System.out.println("i = " + i + ", doubled = " + doubled);
        }
    }
}
