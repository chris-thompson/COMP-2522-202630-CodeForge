package ca.bcit.comp2522.exceptions;

/**
 * A checked exception with a name that says what went wrong.
 *
 * Three of the control-flow examples in this package throw this. They used to
 * throw "new Exception()" instead, which is a habit worth breaking early: a
 * bare Exception tells whoever catches it nothing at all, and it forces them
 * to catch Exception in turn, which swallows every other problem along with
 * the one they meant to handle.
 *
 * Checked means the compiler makes you deal with it. Any method that can throw
 * this must either catch it or declare "throws MyCheckedException", all the
 * way up the call stack until somebody handles it.
 *
 * @author BCIT
 * @version 2026
 */
class MyCheckedException extends Exception {

    /** Version marker for serialization; Exception is Serializable, so this is required. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an object of type MyCheckedException.
     *
     * @param msg a description of the exceptional situation.
     */
    MyCheckedException(final String msg) {
        super(msg);
    }
}
