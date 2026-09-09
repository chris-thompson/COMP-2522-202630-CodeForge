package ca.bcit.comp2522.dataStructures;

/**
 * A simple data structure stores an array of int. It contains an iterator class!
 *<p>
 * It is a simple iterable.
 *<p>
 * Pay attention to this.  Read the source code for ArrayList.java as well.
 *<p>
 * What do you see in the iterator that is similar? What is different?
 *
 * @author BCIT
 * @version 2026
 */
public class SimpleDataStructure {
    private static final int SIZE = 15;
    private final int[] arrayOfInts = new int[SIZE];

    /**
     * Creates an object of type DataStructure. Note it is a simple
     * array of sequential integers.
     */
    public SimpleDataStructure() {
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    /**
     * Uses an instance of the EvenIterator inner class to print the even
     * members of the collection. Note the use of hasNext followed by next.
     *<p>
     * Pay attention to the way we instantiate the inner object. We have to
     * use this.new and we assign it to a variable of the correct type.
     */
    public void printEven() {
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    /**
     * Check this out. We are extending an existing Iterator. Check out the Iterator
     * interface (the source code is in the Learning Hub and when you downloaded
     * Java you probably downloaded a file called src.zip that contains it.)
     */
    interface DataStructureIterator extends java.util.Iterator<Integer> { }

    /* Inner class implements the DataStructureIterator interface,
       which extends the Iterator<Integer> interface */
    private final class EvenIterator implements DataStructureIterator {

        // Start stepping through the array from the beginning
        private int nextIndex = 0;

        /**
         * Returns true if this EvenIterator detects another integer to iterate over. This
         * is the object the EvenIterator will "point to" next.
         * @return true if there is another element to iterate over, else false
         */
        @Override
        public boolean hasNext() {
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }

        /**
         * Returns an Integer representing the next integer in the iteration. The
         * integer now "points to" this object.
         * @return next even integer wrapped in an Integer object.
         */
        @Override
        public Integer next() {
            Integer retValue = arrayOfInts[nextIndex];
            nextIndex += 2;
            return retValue;
        }
    }


    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        SimpleDataStructure simpleIterable = new SimpleDataStructure();
        simpleIterable.printEven();
    }
}
