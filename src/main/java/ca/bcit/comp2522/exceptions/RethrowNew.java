package ca.bcit.comp2522.exceptions;

/**
 * A checked exception.
 */
class FirstCheckedException extends Exception {
    /** Version marker for serialization; Exception is Serializable, so this is required. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an object of type OneException.
     * @param string a description of the exceptional situation
     */
    FirstCheckedException(final String string) {
        super(string);
    }
}

/**
 * A checked exception.
 */
class SecondCheckedException extends Exception {
    /** Version marker for serialization; Exception is Serializable, so this is required. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an object of type TwoException.
     * @param string a description of the exceptional situation
     */
    SecondCheckedException(final String string) {
        super(string);
    }
}

/**
 * Demonstrates rethrowing an exception.
 *
 * @author BCIT
 * @version 2026
 */
final class RethrowNew {

    private RethrowNew() {
    }

    /**
     * Throws an exception.
     * @throws FirstCheckedException every single time
     */
    public static void someUsefulMethod() throws FirstCheckedException {
        System.out.println("originating the exception in firstMethod()");
        throw new FirstCheckedException("Thrown from firstMethod()");
    }

    /**
     * Drives the program.
     * @param args unused
     * @throws SecondCheckedException often
     */
    public static void main(final String[] args) throws SecondCheckedException {
        try {
            someUsefulMethod();
        } catch (FirstCheckedException e) {
            System.err.println("Caught in main, e.printStackTrace():");
            e.printStackTrace(System.err);
            System.err.println("About to throw a new SecondCheckedException");
            throw new SecondCheckedException("from main()");
        }
    }
}
