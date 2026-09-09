package ca.bcit.comp2522.dataStructures.stack;

/**
 * StackInheritanceTest.
 *
 * @author BCIT
 * @version 2026
 */
public final class StackInheritanceDemo {

    /** The third value pushed in, so it is the first one to come back out. */
    private static final int THIRD_VALUE = 5;

    private StackInheritanceDemo() {
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {

        StackInheritance stack = new StackInheritance();
        stack.push(-1);
        stack.print();
        stack.push(0);
        stack.print();
        stack.push(1);
        stack.print();
        stack.push(THIRD_VALUE);
        stack.print();

        try {
            while (true) {
                Object removedObject = stack.pop();
                System.out.printf("%s popped%n", removedObject);
                stack.print();
            }
        } catch (EmptySimpleDoublyLinkedListException emptyListException) {
            emptyListException.printStackTrace();
        }
    }
}
