package ca.bcit.comp2522.inheritance.orderOfInitialization;

/**
 * Demonstrates what happens when we call a method
 * from inside a constructor.
 *
 * @author BCIT
 * @version 2026
 */
public final class Widgets {

    private Widgets() {
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final int initialValue = 5;
        new RoundWidget(initialValue);
    }
}

/**
 * A widget can be drawn.
 */
abstract class Widget {
    Widget() {
        System.out.println("Entering Widget constructor, invoking draw()");
        draw();
        System.out.println("Exiting Widget constructor");
    }

    abstract void draw();
}

/**
 * A round widget.
 */
class RoundWidget extends Widget {
    private int radius = 1;

    RoundWidget(final int r) {
        System.out.println("Entering RoundWidget constructor, radius = " + radius);
        radius = r;
        System.out.println("Leaving RoundWidget constructor, radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("Inside RoundWidget draw(), radius = " + radius);
    }
}
