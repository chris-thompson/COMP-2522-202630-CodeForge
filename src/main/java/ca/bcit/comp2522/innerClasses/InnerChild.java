package ca.bcit.comp2522.innerClasses;

/**
 * Outer contains an inner.
 */
class Outer {

    /**
     * Inner belongs to Outer. Why does IntelliJ tell me Inner can be static?
     */
    class Inner {
    }
}

/**
 * InnerChild is a subclass of Outer.Inner. This is how we do it.
 *
 * @author BCIT
 * @version 2026
 */
public class InnerChild extends Outer.Inner {

    // InnerChild() {} // Won't compile

    /**
     * In order to instantiate the specialized version of the Outer.Inner class,
     * we must first instantiate an instance of the Outer class.
     *<p>
     * We MUST have an enclosing instance. We cannot create a freestanding Yolk! All
     * Yolks must be inside Eggs!
     *<p>
     * Try commenting out this constructor and using the zero-param version.
     * @param outer an Outer object
     */
    InnerChild(final Outer outer) {
        outer.super();
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Outer outer = new Outer();
        InnerChild innerChild = new InnerChild(outer);
        System.out.println(innerChild);
    }
}
