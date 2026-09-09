package ca.bcit.comp2522.inheritance.orderOfInitialization;

/**
 * Insect.
 *
 * @author BCIT
 * @version 2026
 */
class Insect {
    /**
     * Protected instance variables need Javadocs.
     */
    protected final int i = 9;

    /**
     * Protected instance variables need Javadocs.
     */
    protected int j;

    /**
     * Constructs an object of type Insect.
     */
    Insect() {
        staticPrinter("i = " + i + ", j = " + j);
        final int value = 39;
        j = value;
    }

    /**
     * Protected instance variables need Javadocs.
     *
     * Checkstyle reports "Static variable definition in wrong order" here.
     * That is deliberate and it is the whole lesson: this static variable sits
     * below a constructor on purpose, to show that static initializers run in
     * the order they appear in the source file, not in the order you might
     * expect from reading the class top-down as if it were a recipe. Run the
     * program and read the output against the source.
     */
    protected static int x1 = staticPrinter("static Insect.x1 initialized");

    protected static int staticPrinter(final String s) {
        System.out.println(s);
        final int value = 47;
        return value;
    }
}

/**
 * The Beetle class teaches us about initialization:
 * 1. Statics (super, then sub)
 * 2. Super instance variables and then constructor
 * 3. Subclass instance variables and then constructor
 *
 * @author BCIT
 * @version 2026
 */
public class Beetle extends Insect {
    private final int k = staticPrinter("Beetle.k initialized");

    /**
     * Constructs an object of type Beetle.
     */
    public Beetle() {
        staticPrinter("k = " + k);
        staticPrinter("j = " + j);
    }

    private static final int X_2 = staticPrinter("static Beetle.x2 initialized");

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        System.out.println("Started program");
        Beetle b = new Beetle();
        Insect i = new Insect();
        System.out.println(b);
        System.out.println(i);
    }

}
