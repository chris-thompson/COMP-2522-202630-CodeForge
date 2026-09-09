package ca.bcit.comp2522.inheritance.abstractClasses;

/**
 * Labrador, a specialized version of Dog.
 *
 * @author BCIT
 * @version 2026
 */
public class Labrador extends Dog {

    private static final int LABRADOR_WEIGHT = 35;
    private final String color;

    /**
     * Constructs an object of type Labrador.
     *
     * @param name  cannot be blank or all whitespace
     * @param color cannot be blank or all whitespace
     * @throws IllegalArgumentException if name or color is blank
     */
    public Labrador(final String name, final String color) {
        super(name);
        if (color != null && !color.trim().isEmpty()) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color cannot be blank");
        }
    }

    /**
     * Returns the color.
     *
     * @return color as a String
     */
    public String getColor() {
        return color;
    }

    /**
     * Speaks.
     *
     * @return woof!
     */
    @Override
    public String speak() {
        return "BOW WOW!";
    }

    /**
     * Returns the average weight in KG for the breed.
     *
     * @return averageWeight a double
     */
    @Override
    public double averageBreedWeightKG() {
        return LABRADOR_WEIGHT;
    }

    /**
     * Labradors are equal if their names and colors are equal.
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

        Labrador labrador = (Labrador) object;

        if (getColor() != null) {
            return getColor().equals(labrador.getColor());
        }
        return labrador.getColor() == null;
    }

    /**
     * Returns a hashCode for this instance of the Dog class.
     *
     * @return hashCode as an int.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        final int usefulPrime = 31;
        if (getColor() != null) {
            result = usefulPrime * result + getColor().hashCode();
        } else {
            result = usefulPrime * result;
        }
        return result;
    }

    /**
     * Returns a String representation of this Labrador.
     *
     * @return description
     * @see Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Labrador{");
        sb.append("color='").append(getColor()).append('\'');
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
