package ca.bcit.comp2522.dataStructures.linkedList;

/**
 * EmptyLinkedListException is an unchecked exception (it extends
 * RuntimeException).
 *
 * @author BCIT
 * @version 2026
 */
public class EmptyLinkedListException extends RuntimeException {
    /** Version marker for serialization; Exception is Serializable, so this is required. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an object of type EmptyLinkedListException.
     * @param name of an empty object.
     */
    public EmptyLinkedListException(final String name) {
        super(name + " is empty");
    }
}
