package ca.bcit.comp2522.dataStructures.stack;

/**
 * StackCompositionDemo.
 *
 * @author BCIT
 * @version 2026
 */
public final class StackCompositionDemo {

    /** The last value pushed in, so it is the first one to come back out. */
    private static final int LAST_VALUE = 5;

    private StackCompositionDemo() {
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {

        StackComposition stack = new StackComposition();
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
