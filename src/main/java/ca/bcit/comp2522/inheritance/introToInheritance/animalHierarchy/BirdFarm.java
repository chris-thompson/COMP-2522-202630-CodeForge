package ca.bcit.comp2522.inheritance.introToInheritance.animalHierarchy;

/**
 * BirdFarm.
 *
 * @author BCIT
 * @version 2026
 */
public final class BirdFarm {

    private BirdFarm() {
    }

    /**
     * Drives the program.
     *
     * @param args unused.
     */
    public static void main(final String[] args) {
        Bird ostrich = new Ostrich(1, "black and white");
        Bird penguin = new Penguin(1, "black and white");
        Bird cormorant = new Cormorant(1, "black");
        ostrich.eat();
        penguin.eat();
        cormorant.eat();
        ostrich.move();
        penguin.move();
        cormorant.move();

    }

}
