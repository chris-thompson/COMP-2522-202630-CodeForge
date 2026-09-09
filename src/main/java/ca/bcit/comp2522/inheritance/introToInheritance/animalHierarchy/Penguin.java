package ca.bcit.comp2522.inheritance.introToInheritance.animalHierarchy;

/**
 * Penguin.
 *
 * @author BCIT
 * @version 2026
 */
public class Penguin extends Bird implements Terrestrial, Aquatic {

    /**
     * Constructs an object of type Penguin.
     *
     * @param age           an int
     * @param featherColour a String
     */
    public Penguin(final int age, final String featherColour) {
        super(age, featherColour);
    }

    /**
     * Swims.
     */
    @Override
    public void swim() {
        System.out.println("Splash!");
    }

    /**
     * Runs.
     */
    @Override
    public void run() {
        System.out.println("Waddle waddle waddle!");
    }

    /**
     * Eats.
     */
    @Override
    void eat() {
        System.out.println("I love oily nutritious fish!");
    }

    /**
     * Penguin moves.
     */
    @Override
    void move() {
        run();
        swim();
    }

    /**
     * Returns a String representation of this Penguin.
     *
     * @return description as a String
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Penguin [age=" + age + "]";
    }


}
