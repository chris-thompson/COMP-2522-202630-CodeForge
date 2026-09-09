package ca.bcit.comp2522.dataStructures.stack;

/**
 * EmptySimpleDoublyLinkedListException is an unchecked exception (it extends RuntimeException).
 *
 * @author BCIT
 * @version 2026
 */
public class EmptySimpleDoublyLinkedListException extends RuntimeException {
    /** Version marker for serialization; Exception is Serializable, so this is required. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an object of type EmptySimpleDoublyLinkedListException.
     * @param name of an empty object.
     */
    public EmptySimpleDoublyLinkedListException(final String name) {
        super(name + " is empty");
    }
}
