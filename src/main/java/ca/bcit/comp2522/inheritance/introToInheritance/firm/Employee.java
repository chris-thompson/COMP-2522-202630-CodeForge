package ca.bcit.comp2522.inheritance.introToInheritance.firm;

import java.util.Scanner;

/**
 * Represents a general paid employee.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public class Employee extends StaffMember {

    private String socialInsuranceNumber;
    private double payRate;

    /**
     * No argument constructor for initializing from a Scanner.
     */
    public Employee() {
    }

    /**
     * Constructor creates an Employee object with the specified information.
     *
     * @param eName       employee name a string
     * @param eAddress    employee address a string
     * @param ePhone      employee phone a string
     * @param socInNumber social insurance number a string
     * @param rate        pay rate a double
     */
    public Employee(final String eName,
                    final String eAddress,
                    final String ePhone,
                    final String socInNumber,
                    final double rate) {
        super(eName, eAddress, ePhone);

        socialInsuranceNumber = socInNumber;
        payRate = rate;
    }

    /**
     * Returns the social insurance number.
     * @return social insurance number as a string
     */
    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    /**
     * Returns the pay rate.
     *
     * @return pay rate as a double
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     * Returns the pay for this employee. Same as pay rate.
     *
     * @return Amount this employee is paid as a double
     */
    @Override
    public double pay() {
        return payRate;
    }

    /**
     * Reads instance data from scanner. Subclasses that add instance data
     * should override to read additional data.
     *
     * @param scan A Scanner constructed to collect the instance data. Each field
     *             must be a token.
     */
    @Override
    public void readInstanceData(final Scanner scan) {
        super.readInstanceData(scan);
        socialInsuranceNumber = scan.next();
        payRate = Double.parseDouble(scan.next());
    }

    /**
     * Compares this Employee with another object for equality.
     *
     * This implementation compares the fields declared in Employee and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Employee
     * @return true if object is equal to this Employee
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

        Employee employee = (Employee) object;

        if (Double.compare(getPayRate(), employee.getPayRate()) != 0) {
            return false;
        }
        return getSocialInsuranceNumber().equals(employee.getSocialInsuranceNumber());
    }

    /**
     * Returns a hash code for this Employee.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Employee
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        final int usefulPrime = 31;
        result = usefulPrime * result + getSocialInsuranceNumber().hashCode();
        temp = Double.doubleToLongBits(getPayRate());
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }


    /**
     * Returns a description of this Employee.
     *
     * This implementation reports the values of the fields declared in
     * Employee. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Employee as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Employee{");
        sb.append("socialInsuranceNumber='").append(getSocialInsuranceNumber()).append('\'');
        sb.append(", payRate=").append(getPayRate());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
