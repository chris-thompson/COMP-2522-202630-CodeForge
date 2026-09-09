package ca.bcit.comp2522.inheritance.introToInheritance.roads;

/**
 * Boulevard is a road that incorporates a green space median.
 *
 * @author BCIT
 * @version 2026
 */
public class Boulevard extends Road {

    private final boolean medianHasTrees;

    /**
     * Constructor for objects of type Boulevard.
     *
     * @param roadName the name of the road as a String
     * @param roadDirection the direction of the road as a Direction enum
     * @param medianHasTrees true if the median has trees, else false
     */
    public Boulevard(final String roadName,
                     final Direction roadDirection,
                     final boolean medianHasTrees) {
        super(roadName, roadDirection);
        this.medianHasTrees = medianHasTrees;
    }

    /**
     * Returns true if the median has trees.
     *
     * @return true if the median has trees, else false
     */
    public boolean getMedianHasTrees() {
        return medianHasTrees;
    }

    /**
     * Compares this Boulevard with another object for equality.
     *
     * This implementation compares the fields declared in Boulevard and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Boulevard
     * @return true if object is equal to this Boulevard
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }

        Boulevard boulevard = (Boulevard) object;

        return getMedianHasTrees() == boulevard.getMedianHasTrees();
    }

    /**
     * Returns a hash code for this Boulevard.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Boulevard
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int usefulPrime = 31;
        if (getMedianHasTrees()) {
            result = usefulPrime * result + 1;
        } else {
            result = usefulPrime * result;
        }
        return result;
    }


    /**
     * Returns a description of this Boulevard.
     *
     * This implementation reports the values of the fields declared in
     * Boulevard. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Boulevard as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Boulevard{");
        sb.append("medianHasTrees=").append(getMedianHasTrees());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
