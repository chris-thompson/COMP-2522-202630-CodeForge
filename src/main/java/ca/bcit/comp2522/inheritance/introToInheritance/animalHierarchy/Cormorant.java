package ca.bcit.comp2522.inheritance.introToInheritance.animalHierarchy;

/**
 * Cormorant.
 *
 * @author BCIT
 * @version 2026
 */
public class Cormorant extends Bird implements Terrestrial, Aquatic, Aerial {

    /**
     * Constructs an object of type Cormorant.
     *
     * @param age           an int
     * @param featherColour a String
     */
    public Cormorant(final int age, final String featherColour) {
        super(age, featherColour);
    }

    /**
     * Flies.
     */
    @Override
    public void fly() {
        System.out.println("I must fly fast and low to avoid eagles");
    }

    /**
     * Swims.
     */
    @Override
    public void swim() {
        System.out.println("I am a great diver, watch out fish");
    }

    /**
     * Runs.
     */
    @Override
    public void run() {
        System.out.println("Watch me run with my winds wide open for balance");

    }

    /**
     * Eats.
     */
    @Override
    void eat() {
        System.out.println("Eat quickly, yum yum");

    }

    /**
     * Moves.
     */
    @Override
    void move() {
        fly();
        run();
        swim();
    }

}
