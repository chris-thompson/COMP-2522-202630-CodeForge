package ca.bcit.comp2522.students;

import java.util.Objects;

/**
 * Represents a street address.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Address {

    private final String streetAddress;
    private final String city;
    private final String province;
    private final String postalCode;

    /**
     * Constructs an Address object with the specified data.
     *
     * @param streetAddress as a String
     * @param city as a String
     * @param province as a String
     * @param postalCode as a String
     */
    public Address(final String streetAddress,
                   final String city,
                   final String province,
                   final String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    /**
     * Returns the street address as a string.
     * @return streetAddress as a String
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Returns the city as a string.
     * @return city as a String
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the province as a string.
     * @return province as a String
     */
    public String getProvince() {
        return province;
    }

    /**
     * Returns the postal code as a string.
     * @return postalCode as a String
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Returns a description of this Address.
     *
     * This implementation reports the values of the fields declared in
     * Address. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Address as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Address{");
        sb.append("streetAddress='").append(getStreetAddress()).append('\'');
        sb.append(", city='").append(getCity()).append('\'');
        sb.append(", province='").append(getProvince()).append('\'');
        sb.append(", postalCode='").append(getPostalCode()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this Address with another object for equality.
     *
     * Two Address objects are equal when all 4 of their fields are equal.
     * Objects.equals is used for each one because it copes with null on
     * either side; writing those null checks out by hand is what made this
     * method forty lines long in an earlier version of this file.
     *
     * @param object the object to compare with this Address
     * @return true if object is a Address with identical fields
     */
    @Override
    public boolean equals(final Object object) {

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Address other = (Address) object;

        return Objects.equals(streetAddress, other.streetAddress)
                && Objects.equals(city, other.city)
                && Objects.equals(province, other.province)
                && Objects.equals(postalCode, other.postalCode);
    }

    /**
     * Returns a hash code for this Address.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Address
     */
    @Override
    public int hashCode() {
        int result;
        if (getStreetAddress() != null) {
            result = getStreetAddress().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        if (getCity() != null) {
            result = usefulPrime * result + getCity().hashCode();
        } else {
            result = usefulPrime * result;
        }
        if (getProvince() != null) {
            result = usefulPrime * result + getProvince().hashCode();
        } else {
            result = usefulPrime * result;
        }
        if (getPostalCode() != null) {
            result = usefulPrime * result + getPostalCode().hashCode();
        } else {
            result = usefulPrime * result;
        }
        return result;
    }
}
