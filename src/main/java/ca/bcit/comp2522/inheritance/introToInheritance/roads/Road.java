package ca.bcit.comp2522.inheritance.introToInheritance.roads;

/**
 * Road.
 *
 * @author BCIT
 * @version 2026
 */
public class Road {

    private final String name;
    private final Direction direction;

    /**
     * Constructor for objects of type Road.
     *
     * @param roadName      the name of the road as a String
     * @param roadDirection the direction of the road as a Direction enum
     */
    public Road(final String roadName, final Direction roadDirection) {
        this.name = roadName;
        this.direction = roadDirection;
    }

    /**
     * Returns the name.
     *
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the direction.
     *
     * @return direction as a Direction enum
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Compares this Road with another object for equality.
     *
     * This implementation compares the fields declared in Road and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Road
     * @return true if object is equal to this Road
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Road road = (Road) object;

        if (getName() != null) {
            if (!getName().equals(road.getName())) {
                return false;
            }
        } else {
            if (road.getName() != null) {
                return false;
            }
        }
        return getDirection() == road.getDirection();
    }

    /**
     * Returns a hash code for this Road.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Road
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
        if (getDirection() != null) {
            result = usefulPrime * result + getDirection().hashCode();
        } else {
            result = usefulPrime * result;
        }
        return result;
    }

    /**
     * Returns a description of this Road.
     *
     * This implementation reports the values of the fields declared in
     * Road. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Road as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Road{");
        sb.append("name='").append(getName()).append('\'');
        sb.append(", direction=").append(getDirection());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
