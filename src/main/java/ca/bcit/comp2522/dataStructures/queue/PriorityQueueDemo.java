package ca.bcit.comp2522.dataStructures.queue;

import java.util.PriorityQueue;

/**
 * PriorityQueueTest.
 *
 * @author BCIT
 * @version 2026
 */
public final class PriorityQueueDemo {

    /** Offered to the queue in this order, which is not the order they come back in. */
    private static final double[] VALUES = {3.2, 9.8, 5.4};

    private PriorityQueueDemo() {
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {

        final PriorityQueue<Double> queue = new PriorityQueue<>();

        // Offered in no particular order. A PriorityQueue does not keep them
        // in insertion order and is not sorted either: it guarantees only
        // that peek() and poll() give you the smallest one remaining.
        for (final double value : VALUES) {
            queue.offer(value);
        }
        System.out.print("Polling from queue: ");
        while (!queue.isEmpty()) {
            System.out.printf("%.1f ", queue.peek());
            queue.poll();
        }
    }
}
