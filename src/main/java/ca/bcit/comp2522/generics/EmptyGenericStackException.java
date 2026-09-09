package ca.bcit.comp2522.generics;


/**
 * EmptyGenericStackException is raised when a pop operation is attempted on an empty stack.
 *
 * @author BCIT
 * @version 2026
 */
public class EmptyGenericStackException extends RuntimeException {
    /** Version marker for serialization; Exception is Serializable, so this is required. */
    private static final long serialVersionUID = 1L;

    /**
     * Create an object of type EmptyGenericStackException.
     *
     * @param message a String message
     */
    public EmptyGenericStackException(final String message) {
        super(message);
    }

}
