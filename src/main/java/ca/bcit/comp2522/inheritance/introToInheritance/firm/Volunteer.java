package ca.bcit.comp2522.inheritance.introToInheritance.firm;

/**
 * Represents a staff member that works as a volunteer.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public class Volunteer extends StaffMember {

    /**
     * No argument constructor. For creating components to be initialized from a
     * Scanner
     */
    public Volunteer() {
    }

    /**
     * Constructs a new Volunteer object using the specified information.
     *
     * @param eName    employee name
     * @param eAddress employee address
     * @param ePhone   employee phone
     */
    public Volunteer(final String eName, final String eAddress, final String ePhone) {
        super(eName, eAddress, ePhone);
    }

    /**
     * Returns a zero pay value for this volunteer.
     *
     * @return amount paid a volunteer, 0.0
     */
    @Override
    public double pay() {
        return 0.0;
    }
}
