package ca.bcit.comp2522.dataStructures.stack;

/**
 * SimpleDoublyLinkedList.
 *
 * @author BCIT
 * @version 2026
 */
public class SimpleDoublyLinkedList {

    private SimpleNode firstNode;
    private SimpleNode lastNode;

    /**
     * Constructs an object of type SimpleDoublyLinkedList. A new SimpleDoublyLinkedList
     * is empty.
     */
    public SimpleDoublyLinkedList() {
        firstNode = null;
        lastNode = null;
    }

    /**
     * Inserts the argument at the head of the SimpleDoublyLinkedList.
     *
     * @param insertItem the datum to insert at the head of the SimpleDoublyLinkedList
     */
    public void insertAtFront(final Object insertItem) {
        if (isEmpty()) {
            firstNode = new SimpleNode(insertItem);
            lastNode = firstNode;
        } else {
            final SimpleNode newNode = new SimpleNode(insertItem);
            newNode.setNext(firstNode);
            firstNode.setPrevious(newNode);
            firstNode = newNode;
        }
    }

    /**
     * Inserts the argument at the tail of the SimpleDoublyLinkedList.
     *
     * @param insertItem the datum to insert at the tail of the SimpleDoublyLinkedList
     */
    public void insertAtBack(final Object insertItem) {
        if (isEmpty()) {
            firstNode = new SimpleNode(insertItem);
            lastNode = firstNode;
        } else {
            final SimpleNode newNode = new SimpleNode(insertItem);
            newNode.setPrevious(lastNode);
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
    }

    /**
     * Removes and returns the element at the head of the SimpleDoublyLinkedList.
     *
     * @return removedItem the datum removed from the head of the SimpleDoublyLinkedList
     * @throws EmptySimpleDoublyLinkedListException if this SimpleDoublyLinkedList is empty
     */
    public Object removeFromFront() throws EmptySimpleDoublyLinkedListException {
        if (isEmpty()) {
            throw new EmptySimpleDoublyLinkedListException(this.toString());
        }
        Object removedItem = firstNode.getObject();

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.getNext();
            firstNode.setPrevious(null);
        }
        return removedItem;
    }

    /**
     * Removes and returns the element at the tail of the SimpleDoublyLinkedList.
     *
     * @return removedItem the datum removed from the tail of the SimpleDoublyLinkedList
     * @throws EmptySimpleDoublyLinkedListException if this list is empty
     */
    public Object removeFromBack() throws EmptySimpleDoublyLinkedListException {
        if (isEmpty()) {
            throw new EmptySimpleDoublyLinkedListException(this.toString());
        }
        Object removedItem = lastNode.getObject();

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            lastNode = lastNode.getPrevious();
            lastNode.setNext(null);
        }
        return removedItem;
    }

    /**
     * Returns true if this SimpleDoublyLinkedList is empty.
     * @return true if empty else false
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Prints the SimpleDoublyLinkedList.
     */
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s\n", this);
            return;
        }

        System.out.printf("The %s is: ", this);
        SimpleNode current = firstNode;

        while (current != null) {
            System.out.printf("%s ", current.getObject());
            current = current.getNext();
        }

        System.out.println("\n");
    }

    /**
     * SimpleNode for a SimpleDoublyLinkedList. This is a static nested class. I put it
     * inside SimpleDoublyLinkedList because nobody else needs to know it exists. It is
     * static because a node needs nothing from any particular list, so it should not
     * carry a hidden reference to one.
     *
     * @author BCIT
     * @version 2026
     */
    static class SimpleNode {

        private final Object data;
        private SimpleNode nextNode;
        private SimpleNode previousNode;

        /**
         * Constructs an object of type SimpleNode.
         *
         * @param object the datum to store in the node
         */
        SimpleNode(final Object object) {
            data = object;
            nextNode = null;
            previousNode = null;
        }

        /**
         * Returns the object in the SimpleNode.
         *
         * @return object
         */
        public Object getObject() {
            return data;
        }

        /**
         * Returns a reference to the next SimpleNode.
         *
         * @return object
         */
        public SimpleNode getNext() {
            return nextNode;
        }

        /**
         * Sets the next SimpleNode to be the argument.
         *
         * @param newNext a SimpleNode
         */
        public void setNext(final SimpleNode newNext) {
            nextNode = newNext;
        }

        /**
         * Returns a reference to the previous SimpleNode.
         *
         * @return the previous SimpleNode, or null if this is the first
         */
        public SimpleNode getPrevious() {
            return previousNode;
        }

        /**
         * Sets the previous SimpleNode to be the argument.
         *
         * @param newPrevious a SimpleNode
         */
        public void setPrevious(final SimpleNode newPrevious) {
            previousNode = newPrevious;
        }
    }
}
