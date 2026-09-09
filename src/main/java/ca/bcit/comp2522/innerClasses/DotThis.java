package ca.bcit.comp2522.innerClasses;

/**
 * This class demonstrates how to correctly use ".this".
 *
 * @author BCIT
 * @version 2026
 */
public class DotThis {

    final void someMethod() {
        System.out.println("DotThis.someMethod()");
    }

    /**
     * Returns an instance of the Inner class.
     * @return inner an instance of Inner
     */
    public Inner inner() {
        return new Inner();
    }

    /**
     * A public inner class. This inner class contains a method called outer
     * that returns a reference to the outer class that owns it.
     */
    public class Inner {

        /**
         * Returns a reference to the encapsulating outer object that owns this
         * Inner object.
         * @return this a reference to the encapsulating DotThis object.
         */
        public DotThis outer() {
            return DotThis.this;
            // return this; // Returns a reference to the Inner object whose outer( ) was called!
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        DotThis dt = new DotThis();
        Inner dti = dt.inner();
        dti.outer().someMethod(); // Daisy chain!
    }
}
