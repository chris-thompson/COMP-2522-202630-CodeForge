package ca.bcit.comp2522.inheritance.introToInheritance;

class Animal {
    private void eat() {
        System.out.println("I'm an animal and I'm eating");
    }
    private void move() {
        System.out.println("I'm an animal and I'm moving");
    }
}

class Bird extends Animal {
    private void eat() {
        System.out.println("I'm a bird and I'm eating");
    }
    private void move() {
        System.out.println("I'm a bird and I'm moving");
    }
}

class Eagle extends Bird {
    public final void eat() {
        System.out.println("I'm an eagle and I'm eating");
    }
    public void move() {
        System.out.println("I'm an eagle and I'm moving");
    }
}

/**
 * It only seems like you can override a private or private final method.
 *
 * @author BCIT
 * @version 2026
 */
public final class OverridingPrivates {

    private OverridingPrivates() {
    }

    /**
     * Drives the illusion.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        Eagle eagle = new Eagle();
        eagle.eat();
        eagle.move();

        Bird bird = eagle;
        // bird.eat(); // Will this work? Why not?
        // bird.move(); // But we can't invoke the methods

        Animal animal = eagle;
        // animal.eat(); // But we can't invoke the methods
        // animal.move(); // But we can't invoke the methods
    }
}
