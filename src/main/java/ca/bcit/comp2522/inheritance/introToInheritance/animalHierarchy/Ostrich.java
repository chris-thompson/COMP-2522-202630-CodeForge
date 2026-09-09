package ca.bcit.comp2522.inheritance.introToInheritance.animalHierarchy;

/**
 * Ostrich.
 *
 * @author BCIT
 * @version 2026
 */
public class Ostrich extends Bird implements Terrestrial {

    /**
     * Constructs an object of type Ostrich.
     *
     * @param age           an int
     * @param featherColour a String
     */
    public Ostrich(final int age, final String featherColour) {
        super(age, featherColour);
    }

    /**
     * Runs.
     */
    @Override
    public void run() {
        System.out.println("Look at how fast I lope across the savannah!");
    }

    /**
     * Eats.
     */
    @Override
    void eat() {
        System.out.println("Watch me gobble up these lizards yum yum!");
    }

    /**
     * Moves.
     */
    @Override
    void move() {
        run();
    }

    /**
     * Returns a String representation of this Ostrich.
     *
     * @return description as a String
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Ostrich [age=" + age + "]";
    }

}
