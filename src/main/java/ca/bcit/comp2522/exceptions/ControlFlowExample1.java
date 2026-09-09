package ca.bcit.comp2522.exceptions;

/**
 * What's happening here?
 *
 * @author BCIT
 * @version 2026
 */
public class ControlFlowExample1 {

    /**
     * Throws an exception.
     * @throws MyCheckedException always thrown
     */
    public void alwaysThrows() throws MyCheckedException {
        throw new MyCheckedException("alwaysThrows always throws");
    }

    /**
     * I think this throws an Exception.  But what happens first?
     * @throws MyCheckedException which is rethrown after being caught
     */
    public void foo() throws MyCheckedException {
        System.out.println("Entering foo()!");
        try {
            System.out.println("Entering try before alwaysThrows()");
            alwaysThrows();
            System.out.println("Exiting try after alwaysThrows()");
        // Catch the specific type you actually expect. Catching Exception
        // catches everything, including bugs you did not mean to hide.
        } catch (MyCheckedException e) {
            System.out.println("Oh no! An exception was thrown by alwaysThrows!");

            // Rethrowing after only printing adds nothing. Either handle the
            // exception here or let it propagate; doing half of each is worse
            // than either. Watch the order the messages print in.
            throw e;
        } finally {
            System.out.println("Finally!");
        }
        System.out.println("Exiting foo()!");
    }

    /**
     * Drives the program.
     * @param args unused
     * @throws MyCheckedException in a circuitous way
     */
    public static void main(final String[] args) throws MyCheckedException {
        ControlFlowExample1 c = new ControlFlowExample1();
        try {
            c.foo();
        } finally {
            System.out.println("The exception has made it to the main "
                    + "finally without being caught!");
        }
    }
}
