package ca.bcit.comp2522.inheritance.introToInheritance.roads;

/**
 * Highway is a fast road that may have an HOV lane.
 *
 * @author BCIT
 * @version 2026
 */
public class Highway extends Road {

    private final boolean hasHovLane;

    /**
     * Constructor for objects of type Highway.
     *
     * @param roadName the name of the road as a String
     * @param roadDirection the direction of the road as a Direction enum
     * @param hasHovLane true if the highway includes an HOV lane else false
     */
    public Highway(final String roadName, final Direction roadDirection, final boolean hasHovLane) {
        super(roadName, roadDirection);
        this.hasHovLane = hasHovLane;
    }

    /**
     * Returns true if the highway has an HOV lane.
     *
     * @return true if the highway has an HOV lane, else false
     */
    public boolean hashHovLane() {
        return hasHovLane;
    }

    /**
     * Compares this Highway with another object for equality.
     *
     * This implementation compares the fields declared in Highway and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Highway
     * @return true if object is equal to this Highway
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

        Highway highway = (Highway) object;

        return hashHovLane() == highway.hashHovLane();
    }

    /**
     * Returns a hash code for this Highway.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Highway
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int usefulPrime = 31;
        if (hashHovLane()) {
            result = usefulPrime * result + 1;
        } else {
            result = usefulPrime * result;
        }
        return result;
    }


    /**
     * Returns a description of this Highway.
     *
     * This implementation reports the values of the fields declared in
     * Highway. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Highway as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Highway{");
        sb.append("hasHOVlane=").append(hashHovLane());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
