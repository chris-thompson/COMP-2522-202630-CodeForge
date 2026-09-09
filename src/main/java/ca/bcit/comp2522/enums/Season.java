package ca.bcit.comp2522.enums;

/**
 * Enumerates the values for Season.  Check this out.
 * <p>
 * We can put a constructor in an enumeration. This is fancy stuff.
 * <p>
 * The constructor can accept parameters and assign them to
 * instance variables.  Each member of the enum can "construct"
 * itself.  We just need to put the appropriate arguments in
 * a set of parentheses after the constants.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public enum Season {


    winter("December through February"),
    spring("March through May"),
    summer("June through August"),
    fall("September through November");

    /**
     * Holds string to describe months of season.
     */
    private final String span;

    /**
     * Constructor associates each value with a String.
     *
     * @param months the span of the Season.
     */
    Season(final String months) {
        span = months;
    }

    /**
     * Returns the span for the value.
     *
     * @return span as a String
     */
    public String getSpan() {
        return span;
    }
}
