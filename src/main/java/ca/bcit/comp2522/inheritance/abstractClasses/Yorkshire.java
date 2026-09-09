package ca.bcit.comp2522.inheritance.abstractClasses;

/**
 * Yorkshire, a specialized version of Dog.
 *
 * @author BCIT
 * @version 2026
 */
public class Yorkshire extends Dog {

    private static final int YORKSHIRE_WEIGHT = 4;
    private final boolean ratter;

    /**
     * Constructs an object of type Yorkshire.
     *
     * @param name   cannot be blank or all whitespace
     * @param ratter true if trained to catch rats
     */
    public Yorkshire(final String name, final boolean ratter) {
        super(name);
        this.ratter = ratter;
    }

    /**
     * Returns true if this Yorkshire is a ratter, else false.
     *
     * @return color as a String
     */
    public boolean isRatter() {
        return ratter;
    }

    /**
     * Speaks.
     *
     * @return woof!
     */
    @Override
    public String speak() {
        return "YAPYAPYAP!";
    }

    /**
     * Returns the average weight in KG for the breed.
     *
     * @return averageWeight a double
     */
    @Override
    public double averageBreedWeightKG() {
        return YORKSHIRE_WEIGHT;
    }

    /**
     * Yorkshires are equal if their names and ratter-training are equal.
     *
     * @param object Object
     * @return true if the same else false
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

        Yorkshire yorkshire = (Yorkshire) object;

        return isRatter() == yorkshire.isRatter();
    }

    /**
     * Returns a hashCode for this instance of the Yorkshire class.
     *
     * @return hashCode as an int.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int usefulPrime = 31;
        if (isRatter()) {
            result = usefulPrime * result + 1;
        } else {
            result = usefulPrime * result;
        }
        return result;
    }

/**
     * Returns a String representation of this Yorkshire.
     *
     * @return description
     * @see Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Yorkshire{");
        sb.append("ratter=").append(isRatter()).append('\'');
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
