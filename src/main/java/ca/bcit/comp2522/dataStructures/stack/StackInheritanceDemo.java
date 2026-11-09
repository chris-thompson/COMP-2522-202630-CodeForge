package ca.bcit.comp2522.dataStructures.stack;

/**
 * StackInheritanceDemo.
 *
 * @author BCIT
 * @version 2026
 */
public final class StackInheritanceDemo {

    /** The last value pushed in, so it is the first one to come back out. */
    private static final int LAST_VALUE = 5;

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
        stack.push(LAST_VALUE);
        stack.print();

        while (!stack.isEmpty()) {
            Object removedObject = stack.pop();
            System.out.printf("%s popped%n", removedObject);
            stack.print();
        }

        // The loop looked before it leapt. Popping an empty stack anyway is a
        // programming error, and it throws.
        try {
            stack.pop();
        } catch (EmptySimpleDoublyLinkedListException emptyListException) {
            System.out.println("Popped an empty stack: " + emptyListException.getClass().getSimpleName());
        }
    }
}
