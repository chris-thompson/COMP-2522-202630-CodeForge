package ca.bcit.comp2522.dataStructures.tree;

/**
 * Create a Tree of integers, and then print the Tree out.
 *
 * @author BCIT
 * @version 2026
 */
public final class Driver {

    /** Inserted in this order, which is what decides the shape of the tree. */
    private static final int[] VALUES_TO_INSERT = {2, 4, -5, 0, 8, -3};

    private Driver() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {

        final Tree tree = new Tree();

        // Inserted in this order on purpose: 2 arrives first and becomes the
        // root, so the shape of the tree depends on the order, not just on
        // the set of values. Insert them sorted and you get a linked list.
        for (final int value : VALUES_TO_INSERT) {
            tree.insertNode(value);
        }
        System.out.println("\nIn order");
        tree.inorderTraversal();
        System.out.println("\nPost-order");
        tree.postorderTraversal();
        System.out.println("\nPre-order");
        tree.preorderTraversal();
    }
}
