package ca.bcit.comp2522.inheritance.introToInheritance.animalHierarchy;

/**
 * Bird.
 *
 * @author BCIT
 * @version 2026
 */
public abstract class Bird extends Animal {

    /**
     * The bird's feather colour (this should be an enum!).
     */
    protected String featherColour;

    /**
     * Constructs an object of type Bird.
     *
     * @param age           an int
     * @param featherColour a String
     */
    public Bird(final int age, final String featherColour) {
        super(age);
        this.featherColour = featherColour;
    }
}
