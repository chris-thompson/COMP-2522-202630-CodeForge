package ca.bcit.comp2522.arrays;

/**
 * Represents a school grade.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Grade {

    private final String name;
    private final int lowerBound;

    /**
     * Constructs a Grade object with the specified grade name and numeric lower
     * bound.
     *
     * @param grade  a String
     * @param cutoff an int
     */
    public Grade(final String grade, final int cutoff) {
        name = grade;
        lowerBound = cutoff;
    }

    /**
     * Gets (accesses) the Grade name.
     *
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets (accesses) the Grade lower bound.
     *
     * @return lowerBound as an int
     */
    public int getLowerBound() {
        return lowerBound;
    }


    /**
     * Returns a description of this Grade.
     *
     * This implementation reports the values of the fields declared in
     * Grade. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Grade as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Grade{");
        sb.append("name='").append(getName()).append('\'');
        sb.append(", lowerBound=").append(getLowerBound());
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this Grade with another object for equality.
     *
     * This implementation compares the fields declared in Grade and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Grade
     * @return true if object is equal to this Grade
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Grade grade = (Grade) object;

        if (getLowerBound() != grade.getLowerBound()) {
            return false;
        }
        if (getName() != null) {
            return getName().equals(grade.getName());
        }
        return grade.getName() == null;
    }

    /**
     * Returns a hash code for this Grade.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Grade
     */
    @Override
    public int hashCode() {
        int result;
        if (getName() != null) {
            result = getName().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        result = usefulPrime * result + getLowerBound();
        return result;
    }
}
