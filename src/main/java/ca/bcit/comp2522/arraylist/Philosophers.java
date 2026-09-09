package ca.bcit.comp2522.arraylist;

import java.util.ArrayList;

/**
 * Demonstrates the use of a ArrayList object.
 *
 * @author BCIT
 * @version 2026
 */
public final class Philosophers {

    private Philosophers() { }

    /**
     * Stores and modifies a list of band members.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final ArrayList<String> preSocratics = new ArrayList<>();

        preSocratics.add("Thales");
        preSocratics.add("Anaximander");
        preSocratics.add("Anaximenes");
        preSocratics.add("Pythagoras");
        preSocratics.add("Heraclitus");
        preSocratics.add("Parmenides");
        preSocratics.add("Zeno");
        preSocratics.add("Melissus");
        preSocratics.add("Xenophanes");
        preSocratics.add("Leucippus");
        preSocratics.add("Anaxagoras");
        preSocratics.add("Empedocles");
        preSocratics.add("George");

        System.out.println(preSocratics);
        preSocratics.remove("George");

        System.out.println(preSocratics);
        System.out.println("At index 1: " + preSocratics.get(1));
        final int insertionPoint = 8;
        preSocratics.add(insertionPoint, "Democritus");

        System.out.println("How many are in the list: " + preSocratics.size());
        int index = 0;
        while (index < preSocratics.size()) {
            System.out.println(preSocratics.get(index));
            index++;
        }
    }
}
