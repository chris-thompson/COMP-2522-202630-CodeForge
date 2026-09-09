package ca.bcit.comp2522.variableLength;

import java.util.Arrays;

/**
 * Demonstrates the use of variable length parameter lists.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Family {
    /**
     * Names of family members.
     */
    private final String[] members;

    /**
     * Constructs a Family object by storing the (possibly multiple)
     * names that are passed as passByValue.
     *
     * @param names a variable number of Strings
     */
    public Family(final String... names) {
        members = names;
    }

    /**
     * Returns a description of this Family.
     *
     * This implementation reports the values of the fields declared in
     * Family. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Family as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Family{");
        if (members == null) {
            sb.append("members=").append("null");
        } else {
            sb.append("members=").append(Arrays.asList(members));
        }
        sb.append('}');
        return sb.toString();
    }
}
