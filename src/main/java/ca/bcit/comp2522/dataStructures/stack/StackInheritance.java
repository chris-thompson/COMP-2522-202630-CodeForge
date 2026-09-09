package ca.bcit.comp2522.dataStructures.stack;

/**
 * StackInheritance implements a stack by extending the
 * List and only exposing stack behaviours.  Neat!
 *
 * @author BCIT
 * @version 2026
 */
public class StackInheritance extends SimpleDoublyLinkedList {

    /**
     * Creates an object of type StackInheritance.
     */
    public StackInheritance() {
        super();
    }

    /**
     * Pushes the argument onto this Stack.
     * @param object to add
     */
    public void push(final Object object) {
        insertAtFront(object);
    }

    /**
     * Pops and returns the top of the Stack.
     * @return top of the Stack
     * @throws EmptySimpleDoublyLinkedListException if the Stack is empty.
     */
    public Object pop() throws EmptySimpleDoublyLinkedListException {
        return removeFromFront();
    }
}
