package ca.bcit.comp2522.printingAndConcatenation;

/**
 * Demonstrates escape sequences, and the text block that often replaces them.
 *
 * Some characters cannot simply be typed inside a String literal. A double
 * quote would end the String early; a newline would end the line of source
 * code. An escape sequence is a backslash followed by one more character, and
 * the pair stands for a single character that you could not otherwise write.
 *
 * The ones you will actually use:
 *
 *   \\n   newline
 *   \\t   tab
 *   \\"   double quote
 *   \\\\   a single backslash
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class EscapeSequences {

    private EscapeSequences() {
    }

    /**
     * Prints the same few lines twice: once with escape sequences, and once
     * with a text block.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        System.out.println("--- written with escape sequences ---");

        // \n forces a new line. \t inserts a tab. \" puts a literal double
        // quote inside a String that is itself delimited by double quotes.
        System.out.println("Roses are red,\n\tViolets are blue,\n"
                + "This line has a \"quoted\" word in it,\n"
                + "\tand this one ends with a backslash: \\");

        System.out.println();
        System.out.println("--- the same thing, written as a text block ---");

        // A text block starts and ends with three double quotes. Inside one,
        // newlines are real newlines and a double quote needs no escaping, so
        // most of the backslashes above simply disappear. The closing """ also
        // sets the left margin: everything is indented relative to it.
        System.out.println("""
                Roses are red,
                \tViolets are blue,
                This line has a "quoted" word in it,
                \tand this one ends with a backslash: \\""");
    }
}
