package ca.bcit.comp2522.enums;


/**
 * Enumeration type representing some flavours of ice cream.
 * <p>
 * Sometimes we include an enum inside the file that contains the class that uses it.
 * Other times we  * put the enum in its own file. It depends on how big the enum is
 * and how many classes use it.
 */
enum Flavour {
    vanilla,
    chocolate,
    strawberry,
    fudgeRipple,
    coffee,
    rockyRoad,
    mintChocolateChip,
    cookieDough
}

/**
 * Demonstrates the use of enumerated types.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class IceCream {

    private IceCream() {
    }

    /**
     * Creates and uses variables of the Flavour type.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        Flavour cone1 = Flavour.rockyRoad;
        Flavour cone2 = Flavour.chocolate;

        System.out.println("cone1 value: " + cone1);
        System.out.println("cone1 ordinal: " + cone1.ordinal());
        System.out.println("cone1 name: " + cone1.name());

        System.out.println();
        System.out.println("cone2 value: " + cone2);
        System.out.println("cone2 ordinal: " + cone2.ordinal());
        System.out.println("cone2 name: " + cone2.name());
    }
}
