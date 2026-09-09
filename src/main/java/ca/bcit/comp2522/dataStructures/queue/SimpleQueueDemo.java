package ca.bcit.comp2522.dataStructures.queue;

import ca.bcit.comp2522.dataStructures.linkedList.EmptyLinkedListException;

/**
 * Demonstrates how to use a queue.
 *
 * @author BCIT
 * @version 2026
 */
public final class SimpleQueueDemo {

    /** The third value pushed in, so it is the first one to come back out. */
    private static final int THIRD_VALUE = 5;

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
        simpleQueue.enqueue(THIRD_VALUE);
        simpleQueue.print();

        try {
            while (true) {
                Object removedObject = simpleQueue.dequeue();
                System.out.printf("%s dequeued\n", removedObject);
                simpleQueue.print();
            }
        } catch (EmptyLinkedListException emptyListException) {
            emptyListException.printStackTrace();
        }
    }
}
