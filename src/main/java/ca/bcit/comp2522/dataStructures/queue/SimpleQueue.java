package ca.bcit.comp2522.dataStructures.queue;

import ca.bcit.comp2522.dataStructures.linkedList.AnotherLinkedList;
import ca.bcit.comp2522.dataStructures.linkedList.EmptyLinkedListException;

/**
 * Queue implements a queue by using a list and only exposing
 * queue behaviours.  Neat!
 *
 * @author BCIT
 * @version 2026
 */
public class SimpleQueue {

    private final AnotherLinkedList queueList;

    /**
     * Constructs an object of type Queue.
     */
    public SimpleQueue() {
        queueList = new AnotherLinkedList("queue");
    }

    /**
     * Enqueues the specified object.
     * @param object the element to be added to the queue
     */
    public void enqueue(final Object object) {
        queueList.insertAtBack(object);
    }

    /**
     * Dequeues the next item from the queue.
     * @return object first item in the queue
     * @throws EmptyLinkedListException if the list is already empty
     */
    public Object dequeue() throws EmptyLinkedListException {
        return queueList.removeFromFront();
    }

    /**
     * Returns true if the queue is empty.
     * @return true if empty, else false
     */
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    /**
     * Prints the queue.
     */
    public void print() {
        queueList.print();
    }
}
