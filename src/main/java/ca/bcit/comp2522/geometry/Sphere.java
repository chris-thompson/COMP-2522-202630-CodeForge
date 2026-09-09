package ca.bcit.comp2522.geometry;

import java.util.Objects;

/**
 * Sphere.
 *
 * @author BCIT
 * @version 2026
 */
public final class Sphere {
    private double radius;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    /**
     * Constructs an object of type Sphere.
     *
     * @param radius of the Sphere
     * @param x the x Cartesian coordinate of the centre as a double
     * @param y the y Cartesian coordinate of the centre as a double
     * @param z the z Cartesian coordinate of the centre as a double
     */
    public Sphere(final double radius, final double x, final double y, final double z) {
        this.radius = radius;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.zCoordinate = z;
    }

    /**
     * Returns the radius for this Sphere.
     *
     * @return radius as a double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius for this Sphere.
     *
     * @param radius the radius to set as a double
     */
    public void setRadius(final double radius) {
        this.radius = radius;
    }

    /**
     * Returns the xCoordinate for this Sphere.
     *
     * @return xCoordinate as a double
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Sets the xCoordinate for this Sphere.
     *
     * @param xCoordinate the xCoordinate to set as a double
     */
    public void setxCoordinate(final double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Returns the yCoordinate for this Sphere.
     *
     * @return yCoordinate as a double
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Sets the yCoordinate for this Sphere.
     *
     * @param yCoordinate the yCoordinate to set as a double
     */
    public void setyCoordinate(final double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Returns the zCoordinate for this Sphere.
     *
     * @return zCoordinate as a double
     */
    public double getzCoordinate() {
        return zCoordinate;
    }

    /**
     * Sets the zCoordinate for this Sphere.
     *
     * @param zCoordinate the zCoordinate to set as a double
     */
    public void setzCoordinate(final double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    /**
     * Returns the surface area of this Sphere.
     *
     * @return surfaceArea as a double
     */
    public double getSurfaceArea() {
        final double multiplier = 4.0;
        final double squared = 2;
        return multiplier * Math.PI * Math.pow(radius, squared);
    }

    /**
     * Returns the volume of this Sphere.
     *
     * @return volume as a double
     */
    public double getVolume() {
        final int cubed = 3;
        final double divisor = 4.0 / 3.0;
        return divisor * Math.PI * Math.pow(radius, cubed);
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
        sb.append(", xCoordinate=").append(getxCoordinate());
        sb.append(", yCoordinate=").append(getyCoordinate());
        sb.append(", zCoordinate=").append(getzCoordinate());
        sb.append('}');
        return sb.toString();
    }



    /**
     * Compares this Sphere with another object for equality.
     *
     * Two Spheres are equal when their radius and all three coordinates are
     * equal. Note that this method and hashCode below must always be written
     * as a pair: the contract says that two objects which are equal must
     * return the same hash code. Overriding one and not the other is one of
     * the most common bugs in Java, and it is silent — the object simply goes
     * missing from any HashSet or HashMap you put it in.
     *
     * @param other the object to compare with this Sphere
     * @return true if other is a Sphere with the same radius and position
     */
    @Override
    public boolean equals(final Object other) {

        // An object is always equal to itself, and this is the cheap test.
        if (this == other) {
            return true;
        }

        // null is never equal to anything, and neither is a different type.
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        final Sphere otherSphere = (Sphere) other;

        // Doubles are compared with Double.compare rather than ==, because ==
        // gets NaN and negative zero wrong.
        return Double.compare(radius, otherSphere.radius) == 0
                && Double.compare(xCoordinate, otherSphere.xCoordinate) == 0
                && Double.compare(yCoordinate, otherSphere.yCoordinate) == 0
                && Double.compare(zCoordinate, otherSphere.zCoordinate) == 0;
    }

    /**
     * Returns a hash code for this Sphere.
     *
     * Built from exactly the same four values that equals uses, which is what
     * keeps the two methods consistent with one another.
     *
     * @return a hash code for this Sphere
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRadius(), getxCoordinate(), getyCoordinate(), getzCoordinate());
    }
}
