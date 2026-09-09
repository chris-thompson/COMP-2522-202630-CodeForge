package ca.bcit.comp2522.exceptions;

/**
 * What happens when this executes?
 *
 * @author BCIT
 * @version 2026
 */
public class ControlFlowExample2 {

    /**
     * Throws an exception.
     * @throws MyCheckedException always thrown
     */
    public void alwaysThrows() throws MyCheckedException {
        throw new MyCheckedException("alwaysThrows always throws");
    }

    /**
     * Throws an exception.
     * @throws IllegalArgumentException always thrown
     */
    public void foo() throws IllegalArgumentException {
        System.out.println("Entering foo, about to call alwaysThrows");
        try {
            alwaysThrows();
            System.out.println("Back inside foo after having called alwaysThrows");
        } catch (MyCheckedException e) {
            System.out.println("Caught an exception in foo!");

            // The original exception is passed as the cause. Without it the
            // stack trace of what actually went wrong is thrown away, and you
            // are left debugging the replacement instead of the problem.
            throw new IllegalArgumentException("Oh gosh another exception!", e);
        } finally {
            System.out.println("inside the finally block");
        }
        System.out.println("finished foo");
    }

    /**
     * Does this throw an exception too?
     */
    public void gozaimasu() {
        try {
            System.out.println("Gozaimasu!");
            foo();
        } catch (IllegalArgumentException e) {
            System.out.println("The gozaimasu method caught an exception "
                    + "and a crash has been averted!");
        }
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        ControlFlowExample2 demo = new ControlFlowExample2();
        demo.gozaimasu();
    }
}
