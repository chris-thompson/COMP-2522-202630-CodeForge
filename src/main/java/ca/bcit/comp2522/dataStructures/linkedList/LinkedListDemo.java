package ca.bcit.comp2522.dataStructures.linkedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListDemo.
 *
 * @author BCIT
 * @version 2026
 */
public final class LinkedListDemo {

    private static final String[] COLOURS =
            {"black", "yellow", "green", "blue", "violet", "silver"};
    private static final String[] MORE_COLOURS =
            {"gold", "white", "brown", "blue", "grey", "silver"};

    /**
     * Constructs an object of type ListTest.
     */
    public LinkedListDemo() {

        List<String> firstLinkedList = new LinkedList<>();
        List<String> secondLinkedList = new LinkedList<>();

        Collections.addAll(firstLinkedList, COLOURS);
        Collections.addAll(secondLinkedList, MORE_COLOURS);

        firstLinkedList.addAll(secondLinkedList);
        printList(firstLinkedList);
        convertToUppercaseStrings(firstLinkedList);
        printList(firstLinkedList);

        System.out.print("\nDeleting elements 4 to 6 inclusive...");
        final int lowerBound = 4;
        final int upperBound = 7;
        removeItems(firstLinkedList, lowerBound, upperBound);
        printList(firstLinkedList);
        printReversedList(firstLinkedList);
    }

    /**
     * Prints the specified list of String.
     * @param list a list of String
     */
    public void printList(final List<String> list) {
        System.out.println("\nlist: ");

        for (String color : list) {
            System.out.printf("%s ", color);
        }

        System.out.println();
    }

    /**
     * Converts the elements in the given list of String to uppercase.
     * @param list a list of String
     */
    private void convertToUppercaseStrings(final List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String color = iterator.next();
            iterator.set(color.toUpperCase());
        }
    }

    /*
     * Removes the items in the specified index range from the specified list.
     */
    private void removeItems(final List<String> list, final int start, final int end) {
        list.subList(start, end).clear();
    }

    /*
     * Prints the specified list in reverse.
     */
    private void printReversedList(final List<String> list) {
        ListIterator<String> iterator = list.listIterator(list.size());
        System.out.println("\nReversed List:");
        while (iterator.hasPrevious()) {
            System.out.printf("%s ", iterator.previous());
        }
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        new LinkedListDemo();
    }
}
