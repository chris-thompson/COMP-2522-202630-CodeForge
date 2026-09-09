package ca.bcit.comp2522.inheritance.orderOfInitialization;

class Art {
    Art() {
        super();
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        super();
        System.out.println("Drawing constructor");
    }
}

/**
 * Pay attention to the order of execution.  This is quite
 * linear, but it demonstrates the fundamental principle
 * that the calls to super go all the way up the hierarchy.
 *
 * @author BCIT
 * @version 2026
 */
public class Cartoon extends Drawing {

    /**
     * Constructs an object of type Cartoon.
     */
    public Cartoon() {
        super();
        System.out.println("Cartoon constructor");
    }

    /**
     * Drives the program.
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        Cartoon cartoon = new Cartoon();
        System.out.println(cartoon);
    }
}
