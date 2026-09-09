package ca.bcit.comp2522.geometry;

/**
 * Cube.
 *
 * @author BCIT
 * @version 2026
 */
public final class Cube {
    private double edgeLength;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    /**
     * Constructs an object of type Cube.
     *
     * @param edgeLength of the Cube
     * @param x the x Cartesian coordinate of the centre as a double
     * @param y the y Cartesian coordinate of the centre as a double
     * @param z the z Cartesian coordinate of the centre as a double
     */
    public Cube(final double edgeLength, final double x, final double y, final double z) {
        this.edgeLength = edgeLength;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.zCoordinate = z;
    }

    /**
     * Returns the edgeLength for this Cube.
     *
     * @return edgeLength as a double
     */
    public double getEdgeLength() {
        return edgeLength;
    }

    /**
     * Sets the edgeLength for this Cube.
     *
     * @param edgeLength the edgeLength to set as a double
     */
    public void setEdgeLength(final double edgeLength) {
        this.edgeLength = edgeLength;
    }

    /**
     * Returns the xCoordinate for this Cube.
     *
     * @return xCoordinate as a double
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Sets the xCoordinate for this Cube.
     *
     * @param xCoordinate the xCoordinate to set as a double
     */
    public void setxCoordinate(final double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Returns the yCoordinate for this Cube.
     *
     * @return yCoordinate as a double
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Sets the yCoordinate for this Cube.
     *
     * @param yCoordinate the yCoordinate to set as a double
     */
    public void setyCoordinate(final double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Returns the zCoordinate for this Cube.
     *
     * @return zCoordinate as a double
     */
    public double getzCoordinate() {
        return zCoordinate;
    }

    /**
     * Sets the zCoordinate for this Cube.
     *
     * @param zCoordinate the zCoordinate to set as a double
     */
    public void setzCoordinate(final double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    /**
     * Returns this Cube's surface area.
     *
     * @return surfaceArea as a double
     */
    public double getSurfaceArea() {
        final double six = 6.0;
        final int squared = 2;
        return six * Math.pow(edgeLength, squared);
    }

    /**
     * Returns this Cube's volume.
     *
     * @return volume as a double
     */
    public double getVolume() {
        final int cubed = 3;
        return Math.pow(edgeLength, cubed);
    }

    /**
     * Returns this Cube's face diagonal.
     *
     * @return face diagonal as a double
     */
    public double getFaceDiagonal() {
        final int faceDiagonal = 2;
        return Math.sqrt(faceDiagonal) * edgeLength;
    }

    /**
     * Returns this Cube's space diagonal.
     *
     * @return space diagonal as a double
     */
    public double getSpaceDiagonal() {
        final int spaceDiagonal = 3;
        return Math.sqrt(spaceDiagonal) * edgeLength;
    }

    /**
     * Returns a description of this Cube.
     *
     * This implementation reports the values of the fields declared in
     * Cube. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Cube as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Cube{");
        sb.append("edgeLength=").append(getEdgeLength());
        sb.append(", xCoordinate=").append(getxCoordinate());
        sb.append(", yCoordinate=").append(getyCoordinate());
        sb.append(", zCoordinate=").append(getzCoordinate());
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this Cube with another object for equality.
     *
     * This implementation compares the fields declared in Cube and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Cube
     * @return true if object is equal to this Cube
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Cube cube = (Cube) object;

        if (Double.compare(getEdgeLength(), cube.getEdgeLength()) != 0) {
            return false;
        }
        if (Double.compare(getxCoordinate(), cube.getxCoordinate()) != 0) {
            return false;
        }
        if (Double.compare(getyCoordinate(), cube.getyCoordinate()) != 0) {
            return false;
        }
        return Double.compare(getzCoordinate(), cube.getzCoordinate()) == 0;
    }

    /**
     * Returns a hash code for this Cube.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Cube
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getEdgeLength());
        final int shiftLongToInt = 32;
        result = (int) (temp ^ (temp >>> shiftLongToInt));
        temp = Double.doubleToLongBits(getxCoordinate());
        final int usefulPrime = 31;
        result = usefulPrime * result + (int) (temp ^ (temp >>> shiftLongToInt));
        temp = Double.doubleToLongBits(getyCoordinate());
        result = usefulPrime * result + (int) (temp ^ (temp >>> shiftLongToInt));
        temp = Double.doubleToLongBits(getzCoordinate());
        result = usefulPrime * result + (int) (temp ^ (temp >>> shiftLongToInt));
        return result;
    }
}
