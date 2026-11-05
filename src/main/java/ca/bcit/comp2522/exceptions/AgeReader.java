package ca.bcit.comp2522.exceptions;

/**
 * Translates a low-level failure into one the caller understands, and keeps
 * the original as the cause. Run it to read the stack trace, and step through
 * it in the debugger.
 *
 * @author BCIT
 * @version 2026
 */
public final class AgeReader {

    private AgeReader() {
    }

    /**
     * Parses an age from text.
     *
     * @param text the text to parse; must not be null
     * @return the age the text names
     * @throws BadRecordException if the text is not a whole number
     */
    static int parseAge(final String text) throws BadRecordException {
        try {
            return Integer.parseInt(text);
        } catch (final NumberFormatException cause) {
            throw new BadRecordException("age is not a number: " + text, cause);
        }
    }

    /**
     * Drives the program. It fails on purpose, so that there is a stack trace
     * to read.
     *
     * @param args unused
     * @throws BadRecordException always, because "forty" is not a number
     */
    public static void main(final String[] args) throws BadRecordException {
        System.out.println(parseAge("forty"));
    }
}
