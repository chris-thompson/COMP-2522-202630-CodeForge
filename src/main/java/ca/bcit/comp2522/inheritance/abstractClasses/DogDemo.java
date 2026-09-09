package ca.bcit.comp2522.inheritance.abstractClasses;

/**
 * DogDemo.
 *
 * @author BCIT
 * @version 2026
 */
public final class DogDemo {

    private DogDemo() {
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        //Dog dog = new Dog("Spike");
        //System.out.println(dog.getName() + " says " + dog.speak());

        Dog lab = new Labrador("Parmenides", "Golden");
        System.out.println(lab.getName() + " says " + lab.speak());
        System.out.println(lab.getName() + " weighs " + lab.averageBreedWeightKG());
        System.out.println(lab);

        Dog yorkie = new Yorkshire("Socrates", true);
        System.out.println(yorkie.getName() + " says " + yorkie.speak());
        System.out.println(yorkie.getName() + " weighs " + yorkie.averageBreedWeightKG());
        System.out.println(yorkie);
    }

}
