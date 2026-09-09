package ca.bcit.comp2522.inheritance.introToInheritance.shapes;

/**
 * Shape.
 *
 * @author BCIT
 * @version 2026
 */
public abstract class Shape {

    private final String shapeName;

    /**
     * Constructs an object of type Shape.
     *
     * @param name a String
     */
    public Shape(final String name) {
        this.shapeName = name;
    }

    /**
     * Returns the name of this Shape.
     *
     * @return shapeName as a String
     */
    public String getShapeName() {
        return shapeName;
    }

    /**
     * Returns the surface area of this Shape.
     *
     * @return surfaceArea as a double
     */
    public abstract double surfaceArea();


    /**
     * Returns a description of this Shape.
     *
     * This implementation reports the values of the fields declared in
     * Shape. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Shape as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Shape{");
        sb.append("shapeName='").append(getShapeName()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this Shape with another object for equality.
     *
     * This implementation compares the fields declared in Shape and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Shape
     * @return true if object is equal to this Shape
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Shape shape = (Shape) object;

        if (getShapeName() != null) {
            return getShapeName().equals(shape.getShapeName());
        }
        return shape.getShapeName() == null;
    }

    /**
     * Returns a hash code for this Shape.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Shape
     */
    @Override
    public int hashCode() {
        if (getShapeName() != null) {
            return getShapeName().hashCode();
        }
        return 0;
    }
}
