package ca.bcit.comp2522.exceptions;

/**
 * Reports a record that does not say what it should. This is a checked
 * exception, and it keeps the failure that caused it.
 *
 * @author BCIT
 * @version 2026
 */
public class BadRecordException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs the exception from a message and the failure that caused it.
     *
     * @param message what is wrong, in plain words; must not be null
     * @param cause   the underlying failure; must not be null
     */
    public BadRecordException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
