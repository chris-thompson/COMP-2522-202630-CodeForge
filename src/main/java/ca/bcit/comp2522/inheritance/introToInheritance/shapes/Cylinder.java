package ca.bcit.comp2522.inheritance.introToInheritance.shapes;

/**
 * Cylinder.
 *
 * @author BCIT
 * @version 2026
 */
public final class Cylinder extends Shape {

    private final double radius;
    private final double height;

    /**
     * Constructs an object of type Cylinder.
     *
     * @param radius a positive double
     * @param height a positive double
     * @throws IllegalArgumentException if radius or height is not positive
     */
    public Cylinder(final double radius, final double height) {
        super("Cylinder");
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Positive radius only!");
        }
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Positive height only!");
        }
    }

    /**
     * Returns the radius of this Cylinder.
     *
     * @return radius as a double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns the height of this Cylinder.
     *
     * @return height as a double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the surface area of this Shape.
     *
     * @return surfaceArea as a double
     */
    @Override
    public double surfaceArea() {
        return 2 * Math.PI * getRadius() * (getRadius() + getHeight());
    }


    /**
     * Returns a description of this Cylinder.
     *
     * This implementation reports the values of the fields declared in
     * Cylinder. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Cylinder as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Cylinder{");
        sb.append("radius=").append(getRadius());
        sb.append(", height=").append(getHeight());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this Cylinder with another object for equality.
     *
     * This implementation compares the fields declared in Cylinder and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Cylinder
     * @return true if object is equal to this Cylinder
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

        Cylinder cylinder = (Cylinder) object;

        if (Double.compare(getRadius(), cylinder.getRadius()) != 0) {
            return false;
        }
        return Double.compare(getHeight(), cylinder.getHeight()) == 0;
    }

    /**
     * Returns a hash code for this Cylinder.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Cylinder
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getRadius());
        final int usefulPrime = 31;
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        temp = Double.doubleToLongBits(getHeight());
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }
}
