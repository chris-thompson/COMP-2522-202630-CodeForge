package ca.bcit.comp2522.inheritance.introToInheritance.shapes;

/**
 * Sphere.
 *
 * @author BCIT
 * @version 2026
 */
public final class Sphere extends Shape {

    private final double radius;

    /**
     * Constructs an object of type Sphere.
     *
     * @param radius a positive double
     * @throws IllegalArgumentException if radius is not positive
     */
    public Sphere(final double radius) {
        super("Sphere");
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Positive radii only!");
        }
    }

    /**
     * Returns the radius of this Sphere.
     *
     * @return radius as a double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns the surface area of this Shape.
     *
     * @return surfaceArea as a double
     */
    @Override
    public double surfaceArea() {
        final int four = 4;
        return four * Math.PI * Math.pow(getRadius(), 2);
    }

    /**
     * Returns a description of this Sphere.
     *
     * This implementation reports the values of the fields declared in
     * Sphere. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Sphere as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Sphere{");
        sb.append("radius=").append(getRadius());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this Sphere with another object for equality.
     *
     * This implementation compares the fields declared in Sphere and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Sphere
     * @return true if object is equal to this Sphere
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

        Sphere sphere = (Sphere) object;

        return Double.compare(getRadius(), sphere.getRadius()) == 0;
    }

    /**
     * Returns a hash code for this Sphere.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Sphere
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getRadius());
        final int usefulPrime = 31;
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }
}
