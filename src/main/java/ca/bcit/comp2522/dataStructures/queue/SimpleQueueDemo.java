package ca.bcit.comp2522.dataStructures.queue;

import ca.bcit.comp2522.dataStructures.linkedList.EmptyLinkedListException;

/**
 * Demonstrates how to use a queue.
 *
 * @author BCIT
 * @version 2026
 */
public final class SimpleQueueDemo {

    /** The last value enqueued, so in a queue it is the last one to come back out. */
    private static final int LAST_VALUE = 5;

    private SimpleQueueDemo() {

    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        SimpleQueue simpleQueue = new SimpleQueue();

        simpleQueue.enqueue(-1);
        simpleQueue.print();
        simpleQueue.enqueue(0);
        simpleQueue.print();
        simpleQueue.enqueue(1);
        simpleQueue.print();
        simpleQueue.enqueue(LAST_VALUE);
        simpleQueue.print();

        while (!simpleQueue.isEmpty()) {
            Object removedObject = simpleQueue.dequeue();
            System.out.printf("%s dequeued%n", removedObject);
            simpleQueue.print();
        }

        // The loop looked before it leapt. Dequeuing from an empty queue anyway
        // is a programming error, and it throws.
        try {
            simpleQueue.dequeue();
        } catch (EmptyLinkedListException emptyListException) {
            System.out.println(emptyListException.getMessage());
        }
    }
}
