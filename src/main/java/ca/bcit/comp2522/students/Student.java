package ca.bcit.comp2522.students;

import java.util.Objects;

/**
 * Represents a BCIT student.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Student {

    private final String firstName;
    private final String lastName;
    private final Address homeAddress;
    private final Address schoolAddress;

    /**
     * Constructs a Student object that contains the specified values.
     *
     * @param firstName a String representing the first.name
     * @param lastName a String representing the last name
     * @param homeAddress an Address object containing the home address
     * @param schoolAddress an Address object containing the school address
     */
    public Student(final String firstName,
                   final String lastName,
                   final Address homeAddress,
                   final Address schoolAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.schoolAddress = schoolAddress;
    }

    /**
     * Returns the first name of the Student as a string.
     * @return firstName as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the Student as a string.
     * @return lastName as a String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the home address of the Student as an Address object.
     * @return homeAddress as an Address
     */
    public Address getHomeAddress() {
        return homeAddress;
    }

    /**
     * Returns the school address of the Student as an Address object.
     * @return schoolAddress as an Address
     */
    public Address getSchoolAddress() {
        return schoolAddress;
    }

    /**
     * Returns a description of this Student.
     *
     * This implementation reports the values of the fields declared in
     * Student. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Student as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Student{");
        sb.append("firstName='").append(getFirstName()).append('\'');
        sb.append(", lastName='").append(getLastName()).append('\'');
        sb.append(", homeAddress=").append(getHomeAddress());
        sb.append(", schoolAddress=").append(getSchoolAddress());
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this Student with another object for equality.
     *
     * Two Student objects are equal when all 4 of their fields are equal.
     * Objects.equals is used for each one because it copes with null on
     * either side; writing those null checks out by hand is what made this
     * method forty lines long in an earlier version of this file.
     *
     * @param object the object to compare with this Student
     * @return true if object is a Student with identical fields
     */
    @Override
    public boolean equals(final Object object) {

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Student other = (Student) object;

        return Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(homeAddress, other.homeAddress)
                && Objects.equals(schoolAddress, other.schoolAddress);
    }

    /**
     * Returns a hash code for this Student.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Student
     */
    @Override
    public int hashCode() {
        int result;
        if (getFirstName() != null) {
            result = getFirstName().hashCode();
        } else {
            result = 0;
        }
        final int helpfulPrime = 31;
        if (getLastName() != null) {
            result = helpfulPrime * result + getLastName().hashCode();
        }  else {
            result = helpfulPrime * result;
        }
        if (getHomeAddress() != null) {
            result = helpfulPrime * result + getHomeAddress().hashCode();
        } else {
            result = helpfulPrime * result;
        }
        if (getSchoolAddress() != null) {
            result = helpfulPrime * result + getSchoolAddress().hashCode();
        } else {
            result = helpfulPrime * result;
        }
        return result;
    }
}
