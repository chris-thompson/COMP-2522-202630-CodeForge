package ca.bcit.comp2522.inheritance.introToInheritance;

/**
 * Room.
 *
 * @author BCIT
 * @version 2026
 */
class Room {
    /**
     * Constructs an object of type Room.
     */
    Room() {
        helper();
    }

    /**
     * Helps.
     */
    public void helper() {
        System.out.println("Building a room!");
    }
}

/**
 * Kitchen.
 *
 * @author BCIT
 * @version 2026
 */
class Kitchen extends Room {
    /**
     * Constructs an object of type Kitchen.
     */
    Kitchen() {
        helper();
    }

    /**
     * Helps.
     */
    @Override
    public void helper() {
        System.out.println("Building a kitchen!");
    }
}

/**
 * Demonstrates the use of the instanceof operator.
 *<p>
 * We tend to AVOID this.  Heavy use of instanceof is
 * considered an anti-pattern that tries to circumvent
 * design by polymorphism.
 *
 * @author BCIT
 * @version 2026
 */
public final class InstanceOf {

    private InstanceOf() {
    }

    /**
     * Drives the program.
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        System.out.println("#1");
        Room myRoom = new Room();

        System.out.println("#2");
        Room myKitchen = new Kitchen();

        System.out.println("#1");
        Kitchen anotherKitchen = new Kitchen();

        System.out.println(anotherKitchen instanceof Room);
        System.out.println(myRoom instanceof Room);
        System.out.println(myKitchen instanceof Kitchen);
        System.out.println(myKitchen instanceof Room);
        System.out.println(myRoom instanceof Kitchen);


    }
}
