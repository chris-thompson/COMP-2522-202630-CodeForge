package ca.bcit.comp2522.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstrates the one job only an Iterator can do: removing while looping.
 *
 * You already know the for-each loop, and for reading a collection it is the
 * right tool. But try to remove an element inside a for-each loop and the
 * program throws ConcurrentModificationException at run time. The for-each
 * loop is quietly using an Iterator underneath, and that Iterator notices that
 * the collection changed behind its back and refuses to continue. This is
 * called fail-fast behaviour: the collection would rather stop immediately
 * than carry on and give you silently wrong answers.
 *
 * The fix is to stop hiding the Iterator and use it directly, because an
 * Iterator has a remove method and removing through it keeps the Iterator and
 * the collection in agreement.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class IteratorDemo {

    /** The colours the demonstration starts with. */
    private static final String[] COLOURS = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};

    /** The colours the demonstration then takes away. */
    private static final String[] COLOURS_TO_REMOVE = {"RED", "WHITE", "BLUE"};

    private IteratorDemo() {
    }

    /**
     * Removes from one collection every element that appears in another.
     *
     * This is the standard idiom, and the order of the two calls matters.
     * iterator.next() must be called before iterator.remove(), because remove
     * takes away the element that next just handed you. Calling remove twice
     * in a row, or before any call to next, throws IllegalStateException.
     *
     * @param collection  the collection to remove elements from; it is modified
     * @param unwanted    the elements to look for and remove
     */
    private static void removeColours(final Collection<String> collection,
                                      final Collection<String> unwanted) {

        final Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()) {

            // next() returns the element AND advances past it.
            if (unwanted.contains(iterator.next())) {

                // remove() takes away whatever next() just returned. Only the
                // Iterator may do this during a traversal; calling
                // collection.remove(...) here would throw
                // ConcurrentModificationException on the following next().
                iterator.remove();
            }
        }

        // In Week 13 you will meet a one-line version of this whole method:
        //     collection.removeIf(unwanted::contains);
        // It does exactly what the loop above does, and it is implemented with
        // an Iterator internally, for exactly the reason described here.
    }

    /**
     * Prints every element of a collection on one line.
     *
     * @param label      a heading to print first
     * @param collection the collection to print
     */
    private static void print(final String label,
                              final Collection<String> collection) {
        System.out.println(label);
        for (final String colour : collection) {
            System.out.printf("%s ", colour);
        }
        System.out.println();
        System.out.println();
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final List<String> colours = new ArrayList<>();
        final List<String> unwanted = new ArrayList<>();

        Collections.addAll(colours, COLOURS);
        Collections.addAll(unwanted, COLOURS_TO_REMOVE);

        print("The list to begin with:", colours);

        removeColours(colours, unwanted);

        print("The same list after removeColours:", colours);
    }
}
