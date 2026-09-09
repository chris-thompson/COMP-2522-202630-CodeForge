package ca.bcit.comp2522.dataStructures.stack;


/**
 * StackComposition implements a stack by using a list and only exposing
 * stack behaviours. Neat!
 *
 * @author BCIT
 * @version 2026
 */
public class StackComposition {

    private SimpleDoublyLinkedList stackList;

    /**
     * Constructs an object of type List.
     */
    public StackComposition() {
        stackList = new SimpleDoublyLinkedList();
    }

    /**
     * Pushes the argument onto this Stack.
     * @param object to add
     */
    public void push(final Object object) {
        stackList.insertAtFront(object);
    }

    /**
     * Pops and returns the top of the Stack.
     * @return top of the Stack
     * @throws EmptySimpleDoublyLinkedListException if the Stack is empty.
     */
    public Object pop() throws EmptySimpleDoublyLinkedListException {
        return stackList.removeFromFront();
    }

    /**
     * Returns true if the Stack is empty.
     * @return true if empty, else false
     */
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    /**
     * Prints the Stack.
     */
    public void print() {
        stackList.print();
    }
}
