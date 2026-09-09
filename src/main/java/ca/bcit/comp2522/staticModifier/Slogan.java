package ca.bcit.comp2522.staticModifier;

/**
 * Represents a single slogan string.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Slogan {
    private static int count = 0;

    private final String phrase;

    /**
     * Constructs a Slogan and increments the number of instances created.
     *
     * @param str the String used for the slogan
     */
    public Slogan(final String str) {
        phrase = str;
        count++;
    }

    /**
     * Returns the number of instances of this class that have been
     * created.
     *
     * @return count as an int
     */
    public static int getCount() {
        return count;
    }

    /**
     * Returns this Slogan's phrase as a String.
     * @return phrase as a String
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * Returns a description of this that.
     *
     * This implementation reports the values of the fields declared in
     * that. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this that as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Slogan{");
        sb.append("phrase='").append(getPhrase()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this that with another object for equality.
     *
     * This implementation compares the fields declared in that and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this that
     * @return true if object is equal to this that
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Slogan slogan = (Slogan) object;

        if (getPhrase() != null) {
            return getPhrase().equals(slogan.getPhrase());
        }
        return slogan.getPhrase() == null;
    }

    /**
     * Returns a hash code for this that.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this that
     */
    @Override
    public int hashCode() {
        if (getPhrase() != null) {
            return getPhrase().hashCode();
        }
        return 0;
    }
}
