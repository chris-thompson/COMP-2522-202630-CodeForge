package ca.bcit.comp2522.innerClasses;

/**
 * This is a rotten egg. It doesn't initialize the Yolk object it contains. The
 * variable yolk will store the value null if we do not instantiate it inside
 * the BadEgg's constructor.
 *
 * @author BCIT
 * @version 2026
 */
public class ChickenEggYolkless {
    private int number;
    private Yolk yolk;

    /**
     * Constructs an object of type ChickenEggYolkless.
     */
    public ChickenEggYolkless() {
        yolk = null;
    }

    /**
     * Yolk.
     */
    class Yolk {

        /**
         * Sets the number stored by the enclosing Egg object.
         * @param value an integer
         */
        public void setEggNumber(final int value) {
            number = value;
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        ChickenEggYolkless egg = new ChickenEggYolkless();
        final int usefulInteger = 5;
        egg.yolk.setEggNumber(usefulInteger);
        System.out.println("number = " + egg.number);
    }
}
