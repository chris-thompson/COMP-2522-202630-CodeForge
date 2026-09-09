package ca.bcit.comp2522.inheritance.introToInheritance.firm;

/**
 * Represents an executive staff member, who can earn a bonus.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public class Executive extends Employee {

    private double bonus;

    /**
     * No argument constructor for initializing from a Scanner.
     */
    public Executive() {
    }

    /**
     * Constructors a new Executive object with the specified information.
     *
     * @param eName       employee name a string
     * @param eAddress    employee address a string
     * @param ePhone      employee phone a string
     * @param socInNumber social insurance number a string
     * @param rate        pay rate a double
     */
    public Executive(final String eName,
                     final String eAddress,
                     final String ePhone,
                     final String socInNumber,
                     final double rate) {
        super(eName, eAddress, ePhone, socInNumber, rate);
    }

    /**
     * Returns the bonus for this executive.
     * @return bonus as a double
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * Awards the specified bonus to this executive.
     *
     * @param execBonus Amount of bonus as a double
     */
    public void awardBonus(final double execBonus) {
        bonus = execBonus;
    }

    /**
     * Computes and returns the pay for an executive, which is the regular
     * employee payment plus a one-time bonus.
     *
     * @return amount paid, including whatever bonus is due, as a double
     */
    @Override
    public double pay() {
        return super.pay() + bonus;
    }

    /**
     * Compares this Executive with another object for equality.
     *
     * This implementation compares the fields declared in Executive and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Executive
     * @return true if object is equal to this Executive
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

        Executive executive = (Executive) object;

        return Double.compare(getBonus(), executive.getBonus()) == 0;
    }

    /**
     * Returns a hash code for this Executive.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Executive
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getBonus());
        final int usefulPrime = 31;
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }


    /**
     * Returns a description of this Executive.
     *
     * This implementation reports the values of the fields declared in
     * Executive. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Executive as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Executive{");
        sb.append("bonus=").append(getBonus());
        sb.append(", ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
