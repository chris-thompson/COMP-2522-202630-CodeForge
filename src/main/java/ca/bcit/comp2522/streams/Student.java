package ca.bcit.comp2522.streams;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * A simple student.
 *
 * @author BCIT
 * @version 2026
 */
public final class Student {

    /**
     * A student has a standing.
     */
    public enum Standing {
        HONOURS, SATISFACTORY, ON_PROBATION, GRADUATE
    }

    private final String name;
    private final LocalDate birthday;
    private Standing standing;
    private final String emailAddress;

    /**
     * Constructs an object of type Student. A new student has SATISFACTORY Standing.
     *
     * @param name a String
     * @param birthday a LocalDate
     * @param emailAddress a String
     */
    public Student(final String name, final LocalDate birthday, final String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.standing = Standing.SATISFACTORY;
        this.emailAddress = emailAddress;
    }

    /**
     * Returns age in years.
     * @return age in years as an int
     */
    public int getAgeInYears() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * Returns name.
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns student's Standing.
     * @return standing as a Student.Standing
     */
    public Standing getStanding() {
        return standing;
    }

    /**
     * Returns the email address.
     * @return email address as a String.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the Standing.
     * @param standing a Student.Standing
     */
    public void setStanding(final Standing standing) {
        this.standing = standing;
    }


    /**
     * Returns true if the argument is equal to this Student, else false.
     * @param o an Object
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return getName().equals(student.getName())
                && birthday.equals(student.birthday)
                && getStanding() == student.getStanding()
                && getEmailAddress().equals(student.getEmailAddress());
    }

    /**
     * Returns a hashCode for this Student.
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), birthday, getStanding(), getEmailAddress());
    }

    /**
     * Returns a description of this Standing.
     *
     * This implementation reports the values of the fields declared in
     * Standing. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Standing as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", standing=").append(standing);
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append(", ageInYears=").append(getAgeInYears());
        sb.append('}');
        return sb.toString();
    }
}
