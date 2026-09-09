package ca.bcit.comp2522.innerClasses;

/**
 * Check out this super simple calculator. This contains lambda!
 *
 * @author BCIT
 * @version 2026
 */
public class Calculator {

    /**
     * An integer operation accepts two integers and returns an integer.
     */
    public interface IntegerMath {

        /**
         * Performs an operation.
         * @param first an integer
         * @param second an integer
         * @return result of the operation
         */
        int operation(int first, int second);
    }

    /**
     * Performs a binary operation and returns the result.
     * @param first an int
     * @param second an int
     * @param operation an instance of IntegerMath
     * @return result as an integer
     */
    public int operateBinary(final int first, final int second, final IntegerMath operation) {
        return operation.operation(first, second);
    }

    /**
     * Drives the program.
     *
     * Note the parameter type: String... rather than String[]. The three dots
     * make it a variable-length argument list, which you will meet properly
     * in Week 4. For main it makes no difference at all.
     *
     * @param args unused
     */
    public static void main(final String... args) {

        final int firstOperand = 40;
        final int secondOperand = 2;
        final int thirdOperand = 20;
        final int fourthOperand = 10;

        final Calculator myApp = new Calculator();
        // This is a method reference. Java borrowed the :: syntax from C++.
        IntegerMath addition = Integer::sum;
        // This is a lambda, which is a very compact form of anonymous class.
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println(firstOperand + " + " + secondOperand + " = "
                + myApp.operateBinary(firstOperand, secondOperand, addition));
        System.out.println(thirdOperand + " - " + fourthOperand + " = "
                + myApp.operateBinary(thirdOperand, fourthOperand, subtraction));
    }
}
