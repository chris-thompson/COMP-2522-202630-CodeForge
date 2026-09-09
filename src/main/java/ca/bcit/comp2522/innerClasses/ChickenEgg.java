package ca.bcit.comp2522.innerClasses;

/**
 * A ChickenEgg contains an integer and a Yolk. Gobble, gobble.
 *
 * @author BCIT
 * @version 2026
 */
public class ChickenEgg {

    private int calories;
    private final Yolk yolk;

    /**
     * Constructs an object of type ChickenEgg. Also constructs the
     * Yolk inside the ChickenEgg.
     */
    public ChickenEgg() {
        yolk = new Yolk();
    }

    /**
     * Yolk. Every Yolk belongs to a ChickenEgg.
     */
    public class Yolk {

        /**
         * Changes the number stored in the encapsulating ChickenEgg.
         * @param value an integer
         */
        public void setNumber(final int value) {
            calories = value;
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        ChickenEgg chickenEgg = new ChickenEgg();
        final int usefulInteger = 5;
        chickenEgg.yolk.setNumber(usefulInteger);
        System.out.println("number = " + chickenEgg.calories);
    }
}

