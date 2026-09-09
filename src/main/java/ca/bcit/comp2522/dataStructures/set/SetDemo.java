package ca.bcit.comp2522.dataStructures.set;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SetDemo.
 *
 * @author BCIT
 * @version 2026
 */
public class SetDemo {
    private static final String[] COLOURS =
            {"red", "white", "blue", "green", "grey", "orange",
             "tan", "white", "cyan", "peach", "grey", "orange"};

    /**
     * Constructs an object of type SetDemo.
     */
    public SetDemo() {
        List<String> list = Arrays.asList(COLOURS);
        System.out.printf("ArrayList: %s%n", list);
        printNonDuplicates(list);
    }

    /*
     * Prints non-duplicates in the provided collection of String.
     */
    private void printNonDuplicates(final Collection<String> collection) {
        Set<String> set = new HashSet<>(collection);
        System.out.println("\nNon-duplicates are: ");
        for (String value : set) {
            System.out.printf("%s ", value);
        }
        System.out.println();
    }

    /**
     * Drives the program.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        new SetDemo();
    }
}
