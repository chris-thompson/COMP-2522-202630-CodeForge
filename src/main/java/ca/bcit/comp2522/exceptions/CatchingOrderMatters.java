package ca.bcit.comp2522.exceptions;

/**
 * A custom checked Exception.
 */
class Annoyance extends Exception {
    /** Version marker for serialization; Exception is Serializable, so this is required. */
    private static final long serialVersionUID = 1L;

}

/**
 * A custom checked Exception that is a subclass of Annoyance.
 */
class Sneeze extends Annoyance {
    /** Version marker for serialization; Exception is Serializable, so this is required. */
    private static final long serialVersionUID = 1L;

}

/**
 * What is happening here?
 *
 * @author BCIT
 * @version 2026
 */
public final class CatchingOrderMatters {

    private CatchingOrderMatters() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {

        // Which exception we throw is decided at run time, so the compiler
        // cannot predict it and both catch blocks below are genuinely
        // reachable. Run this a few times: you will see both messages.
        final java.util.Random random = new java.util.Random();

        try {
            if (random.nextBoolean()) {
                throw new Sneeze();
            } else {
                throw new Annoyance();
            }

        // Sneeze IS-A Annoyance, so the more specific type must be caught
        // first. Java tries each catch block in order and takes the first one
        // that matches. Swap these two blocks and the file will not compile:
        // the compiler tells you Sneeze "has already been caught".
        } catch (Sneeze sneeze) {
            System.err.println("Caught Sneeze");
        } catch (Annoyance annoyance) {
            System.err.println("Caught Annoyance");
        }
    }
}
