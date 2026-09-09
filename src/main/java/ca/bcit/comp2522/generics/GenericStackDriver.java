package ca.bcit.comp2522.generics;

/**
 * Tests the GenericStack.
 *
 * @author BCIT
 * @version 2026
 */
public class GenericStackDriver {

    private final double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
    private final int[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    private GenericStack<Double> doubleGenericStack;
    private GenericStack<Integer> integerGenericStack;

    /**
     * Tests the GenericStack methods.
     */
    public void testStacks() {
        final int stackSize = 10;
        doubleGenericStack = new GenericStack<>(stackSize);
        integerGenericStack = new GenericStack<>(stackSize);

        testPushDouble();
        testPopDouble();
        testPushInteger();
        testPopInteger();
    }

    /**
     * Tests the GenericStack push method.
     */
    public void testPushDouble() {
        try {
            System.out.println("\nPushing elements onto doubleStack");
            for (double element : doubleElements) {
                System.out.printf("%.1f ", element);
                doubleGenericStack.push(element);
            } // end for
        } catch (FullGenericStackException fullGenericStackException) {
            System.err.println();
            fullGenericStackException.printStackTrace();
        }
    }

    /**
     * Tests the GenericStack pop method.
     */
    public void testPopDouble() {
        try {
            System.out.println("\nPopping elements from doubleStack");
            double popValue;
            while (true) { // Terrible idea!
                popValue = doubleGenericStack.pop();
                System.out.printf("%.1f ", popValue);
            }
        } catch (EmptyGenericStackException emptyGenericStackException) {
            System.err.println();
            emptyGenericStackException.printStackTrace();
        }
    }

    /**
     * Tests the GenericStack push method.
     */
    public void testPushInteger() {
        try {
            System.out.println("\nPushing elements onto integerStack");

            for (int element : integerElements) {
                System.out.printf("%d ", element);
                integerGenericStack.push(element);
            }
        } catch (FullGenericStackException fullGenericStackException) {
            System.err.println();
            fullGenericStackException.printStackTrace();
        }
    }

    /**
     * Tests the GenericStack pop method.
     */
    public void testPopInteger() {
        try {
            System.out.println("\nPopping elements from integerStack");
            int popValue;
            while (true) {
                popValue = integerGenericStack.pop();
                System.out.printf("%d ", popValue);
            }
        } catch (EmptyGenericStackException emptyGenericStackException) {
            System.err.println();
            emptyGenericStackException.printStackTrace();
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        GenericStackDriver application = new GenericStackDriver();
        application.testStacks();
    }
}
