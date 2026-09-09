package ca.bcit.comp2522.generics;


/**
 * FullGenericStackException is raised when a push operation is attempted on a full stack.
 *
 * @author BCIT
 * @version 2026
 */
public class FullGenericStackException extends RuntimeException {
    /** Version marker for serialization; Exception is Serializable, so this is required. */
    private static final long serialVersionUID = 1L;

    /**
     * Create an object of type FullStackException.
     *
     * @param exception a String message
     */
    public FullGenericStackException(final String exception) {
        super(exception);
    }
}
