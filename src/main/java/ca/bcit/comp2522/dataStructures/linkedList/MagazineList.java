package ca.bcit.comp2522.dataStructures.linkedList;

/**
 * Represents a collection of magazines.
 *
 * @author BCIT
 * @version 2026
 */
public class MagazineList {

    private MagazineNode head;

    /**
     * Constructs a new MagazineList object that is empty.
     */
    public MagazineList() {
        head = null;
    }

    /**
     * Adds the specified Magazine to this MagazineList. Creates a new
     * MagazineNode object and adds it to the end of the linked list.
     *
     * @param mag The magazine to add.
     */
    public void add(final Magazine mag) {
        MagazineNode node = new MagazineNode(mag);
        MagazineNode current;

        if (head == null) {
            head = node;
        } else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    /**
     * Returns a String representation of this MagazineList.
     *
     * @return toString The list of magazines.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        MagazineNode current = head;

        while (current != null) {
            result.append(current.magazine).append("\n");
            current = current.next;
        }

        return result.toString();
    }

    /*
     * An inner class that represents a node in the magazine list. The public
     * variables are accessed by the MagazineList class
     *
     * @author BCIT
     * @version 2026
     */
    private class MagazineNode {

        /*
         * The magazine stored in this node.
         */
        private final Magazine magazine;

        /*
         * The next magazine in the list.
         */
        private MagazineNode next;

        /*
         * Constructs a new MagazineNode object that contains the specified
         * Magazine.
         *
         * @param mag The Magazine to store in this node.
         */
        MagazineNode(final Magazine mag) {
            magazine = mag;
            next = null;
        }
    }
}

