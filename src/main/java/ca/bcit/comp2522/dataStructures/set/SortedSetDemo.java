package ca.bcit.comp2522.dataStructures.set;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * SortedSetDemo demonstrates how to instantiate and use a
 * TreeSet, which is a type of SortedSet.
 *
 * @author BCIT
 * @version 2026
 */
public class SortedSetDemo {

    private static final String[] NAMES =
            {"yellow", "green", "black", "tan", "grey", "white", "orange", "red", "green" };

    /**
     * Constructs an object of type SortedSetDemo.
     */
    public SortedSetDemo() {
        SortedSet<String> tree = new TreeSet<>(Arrays.asList(NAMES));

        System.out.println("Sorted set: ");
        printSet(tree);

        System.out.print("\nheadSet (\"orange\"):  ");
        printSet(tree.headSet("orange"));

        System.out.print("tailSet (\"orange\"):  ");
        printSet(tree.tailSet("orange"));

        System.out.printf("first: %s%n", tree.first());
        System.out.printf("last : %s%n", tree.last());
    }

    /*
     * Prints the specified set of String.
     */
    private void printSet(final SortedSet<String> set) {
        for (String value : set) {
            System.out.print(value + " ");
        }
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        new SortedSetDemo();
    }
}
