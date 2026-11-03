package ca.bcit.comp2522.exceptions;

public class BadRecordException extends Exception {
    private static final long serialVersionUID = 1L;

    public BadRecordException(final String message, final Throwable cause) {
        super(message, cause);
    }
}