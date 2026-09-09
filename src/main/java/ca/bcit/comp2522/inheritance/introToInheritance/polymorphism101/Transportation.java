package ca.bcit.comp2522.inheritance.introToInheritance.polymorphism101;

/**
 * Cars drive.
 */
interface Car {
    /**
     * Drive.
     */
    void drive();
}

/**
 * Boats sail.
 */
interface Boat {
    /**
     * Sail.
     */
    void sail();
}

/**
 * Vehicles turn.
 */
class Vehicle {
    /**
     * Turn.
     */
    public void turn() {
        System.out.println("Turning vehicle");
    }
}

/**
 * Hovercraft.
 */
class Hovercraft extends Vehicle implements Car, Boat {
    /**
     * Drive.
     */
    @Override
    public void drive() {
        System.out.println("drive on ground");
    }

    /**
     * Sail.
     */
    @Override
    public void sail() {
        System.out.println("sail on water");
    }
}

/**
 * Porsche.
 */
class Porsche extends Vehicle implements Car {

    /**
     * Drive.
     */
    @Override
    public void drive() {
        System.out.println("drive very fast - ZOOOM!");
    }
}

/**
 * Demonstrates polymorphism.
 *
 * @author BCIT
 * @version 2026
 */
public final class Transportation {

    private Transportation() {
    }

    /**
     * Test drive the specified Car.
     * @param c a Car
     */
    private void testDrive(final Car c) {
        c.drive();
    }

    /**
     * Sail the specified Boat.
     * @param b a Boat
     */
    private void testSail(final Boat b) {
        b.sail();
    }

    /**
     * Turn the specified Vehicle.
     * @param v a vehicle to turn
     */
    private void testTurn(final Vehicle v) {
        v.turn();
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Transportation t = new Transportation();
        Porsche p = new Porsche();
        Hovercraft h = new Hovercraft();
        t.testDrive(p);
        t.testDrive(h);
        t.testSail(h);
        t.testTurn(p);
        t.testTurn(h);
    }
}
