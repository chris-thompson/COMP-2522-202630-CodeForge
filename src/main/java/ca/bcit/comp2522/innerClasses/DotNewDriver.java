package ca.bcit.comp2522.innerClasses;

/**
 * Drives DotNew, from outside DotNew.
 *
 * The main method used to live inside DotNew itself, and the Javadoc there
 * asked whether anything would have to change if it were moved into a separate
 * driver class. This class is the answer: nothing changes at all. The syntax
 * for creating an inner-class object is the same either way.
 *
 * What the syntax says is the thing worth understanding. An inner class that is
 * not static belongs to an *instance* of its outer class, not to the class
 * itself. So you cannot write "new DotNew.Inner()" — there is no outer object
 * for it to belong to. You must first have a DotNew object, and then ask that
 * particular object for an Inner. That is what "dn.new Inner()" means: the
 * unusual-looking "dn.new" is you naming which DotNew the new Inner belongs to.
 *
 * @author BCIT
 * @version 2026
 */
public final class DotNewDriver {

    private DotNewDriver() {
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {

        // An inner class needs an instance of its outer class to live inside,
        // so we build the DotNew object first.
        final DotNew outer = new DotNew();

        // Now ask that specific DotNew object for an Inner of its own.
        final DotNew.Inner inner = outer.new Inner();

        System.out.println(inner);
    }
}
