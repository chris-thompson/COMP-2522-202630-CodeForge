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
            firstNode = new SimpleNode(insertItem, firstNode);
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
            lastNode.setNext(new SimpleNode(insertItem));
            lastNode = lastNode.getNext();
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
            SimpleNode current = firstNode;

            while (current.getNext() != lastNode) {
                current = current.getNext();
            }
            lastNode = current;
            current.setNext(null);
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
     * SimpleNode for a SimpleLinkedList. This is a static class. I put it inside the
     * SimpleDoublyLinkedList class because nobody else needs to know it exists. I made
     * it static to demonstrate that a static class does NOT get special access to
     * the private members of the outer class. I did this for encapsulation. Static
     * inner classes demonstrate good encapsulation and good information hiding because
     * the information inside the outer class is hidden.
     *
     * @author BCIT
     * @version 2026
     */
    static class SimpleNode {

        private final Object data;
        private SimpleNode nextNode;

        /**
         * Constructs an object of type SimpleNode.
         *
         * @param object the datum to store in the node
         */
        SimpleNode(final Object object) {
            this(object, null);
        }

        /**
         * Constructs an object of type SimpleNode.
         *
         * @param object the datum to store in the SimpleNode
         * @param nextNode the next nextNode
         */
        SimpleNode(final Object object, final SimpleNode nextNode) {
            data = object;
            this.nextNode = nextNode;
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
    }
}
