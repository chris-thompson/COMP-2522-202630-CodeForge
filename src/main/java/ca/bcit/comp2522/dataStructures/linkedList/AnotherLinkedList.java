package ca.bcit.comp2522.dataStructures.linkedList;

/**
 * ListNode.
 *
 * @author BCIT
 * @version 2026
 */
class ListNode {

    private final Object data;
    private ListNode nextNode;

    /**
     * Constructs an object of type ListNode.
     *
     * @param object the datum
     */
    ListNode(final Object object) {
        this(object, null);
    }

    /**
     * Constructs an object of type ListNode.
     *
     * @param object the datum
     * @param node the next node in the list
     */
    ListNode(final Object object, final ListNode node) {
        data = object;
        nextNode = node;
    }

    /**
     * Returns the object stored in the ListNode.
     *
     * @return object
     */
    public Object getObject() {
        return data;
    }

    /**
     * Returns a reference to the next Node.
     *
     * @return object
     */
    public ListNode getNext() {
        return nextNode;
    }

    /**
     * Sets the next Node to be the argument.
     *
     * @param newNext a ListNode
     */
    public void setNext(final ListNode newNext) {
        nextNode = newNext;
    }
}

/**
 * AnotherLinkedList.
 *
 * @author BCIT
 * @version 2026
 */
public class AnotherLinkedList {

    private ListNode firstNode;
    private ListNode lastNode;
    private final String name;

    /**
     * Constructs an object of type AnotherLinkedList.
     */
    public AnotherLinkedList() {
        this("list");
    }

    /**
     * Constructs an object of type AnotherLinkedList.
     *
     * @param listName a String
     */
    public AnotherLinkedList(final String listName) {
        name = listName;
        firstNode = null;
        lastNode = null;
    }

    /**
     * Inserts the argument at the front of the AnotherLinkedList.
     *
     * @param insertItem an object
     */
    public void insertAtFront(final Object insertItem) {
        if (isEmpty()) {
            firstNode = new ListNode(insertItem);
            lastNode = firstNode;
        } else {
            firstNode = new ListNode(insertItem, firstNode);
        }
    }

    /**
     * Inserts the argument at the back of the AnotherLinkedList.
     *
     * @param insertItem an object
     */
    public void insertAtBack(final Object insertItem) {
        if (isEmpty()) {
            firstNode = new ListNode(insertItem);
            lastNode = firstNode;
        } else {
            lastNode.setNext(new ListNode(insertItem));
            lastNode = lastNode.getNext();
        }
    }

    /**
     * Removes and returns the element at the front of the AnotherLinkedList.
     *
     * @return removedItem an object
     * @throws EmptyLinkedListException if this AnotherLinkedList is empty.
     */
    public Object removeFromFront() throws EmptyLinkedListException {
        if (isEmpty()) {
            throw new EmptyLinkedListException(name);
        }
        Object removedItem = firstNode.getObject();

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.getNext();
        }
        return removedItem;
    }

    /**
     * Removes and returns the element at the back of the AnotherLinkedList.
     *
     * @return removedItem an object
     * @throws EmptyLinkedListException if this AnotherLinkedList is empty.
     */
    public Object removeFromBack() throws EmptyLinkedListException {
        if (isEmpty()) {
            throw new EmptyLinkedListException(name);
        }
        Object removedItem = lastNode.getObject();

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            ListNode current = firstNode;

            while (current.getNext() != lastNode) {
                current = current.getNext();
            }
            lastNode = current;
            current.setNext(null);
        }
        return removedItem;
    }

    /**
     * Returns true if this AnotherLinkedList is empty.
     * @return true if empty else false
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Prints the AnotherLinkedList.
     */
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s\n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode current = firstNode;

        while (current != null) {
            System.out.printf("%s ", current.getObject());
            current = current.getNext();
        }

        System.out.println("\n");
    }
}
