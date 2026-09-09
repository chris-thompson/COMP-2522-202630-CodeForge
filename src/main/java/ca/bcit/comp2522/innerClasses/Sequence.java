package ca.bcit.comp2522.innerClasses;

/**
 * Selector permits us to visit elements in a Sequence.
 */
interface   Selector {
    boolean end();
    Object  current();
    void    next();
}

/**
 * Sequence stores an ordered collection of elements.
 *
 * @author BCIT
 * @version 2026
 */
public class Sequence {

    private final Object[] items;
    private int next = 0;

    /**
     * Creates an object of type Sequence.
     * @param size the proposed size of the Sequence (an int)
     */
    public Sequence(final int size) {
        items = new Object[size];
    }

    /**
     * Adds the specified object to this Sequence.
     * @param newElement an Object
     */
    public void add(final Object newElement) {
        if (next < items.length) {
            items[next++] = newElement;
        }
    }

    /* This private inner class implements the Selector interface. So cool! */
    private final class SequenceSelector implements Selector {
        private int index = 0;

        /**
         * Returns true if this SequenceSelector is at the end of the Sequence.
         * @return true if we have visited all the elements in the Sequence, else false
         */
        @Override
        public boolean end() {
            return index == items.length;
        }

        /**
         * Returns a reference to the element in the Sequence currently pointed at.
         * @return element currently being visited by this SequenceSelector
         */
        @Override
        public Object current() {
            return items[index];
        }

        /**
         * Increments the pointer.
         */
        @Override
        public void next() {
            if (index < items.length) {
                index++;
            }
        }
    }

    /**
     * Returns  new SequenceSelector for iterating over this Sequence.
     * @return selector a SequenceSelector
     */
    Selector selector() {
        return new SequenceSelector();
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final int size = 10;
        Sequence sequence = new Sequence(size);
        for (int value = 0; value < size; value++) {
            sequence.add(Integer.toString(value));
        }
        Selector selector = sequence.selector(); // Note the datatype of the variable. Why?
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
