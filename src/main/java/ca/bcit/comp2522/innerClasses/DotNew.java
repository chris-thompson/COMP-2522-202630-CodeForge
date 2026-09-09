package ca.bcit.comp2522.innerClasses;

/**
 * The DotNew class demonstrates how to instantiate an inner class.
 *
 * @author BCIT
 * @version 2026
 */
public final class DotNew {

    /**
     * Constructs an object of type DotNew.
     */
    public DotNew() {
        System.out.println("Constructing a DotNew object");
    }

    /**
     * A public inner class.
     */
    public class Inner {

        /**
         * Constructs an object of type Inner.
         */
        public Inner() {
            System.out.println("Constructing an Inner object");
        }

    }

}
