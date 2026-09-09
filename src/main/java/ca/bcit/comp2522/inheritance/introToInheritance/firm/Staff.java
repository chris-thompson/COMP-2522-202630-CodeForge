package ca.bcit.comp2522.inheritance.introToInheritance.firm;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the personnel staff of a particular business.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public class Staff {

    private static final double EXECUTIVE_BONUS = 500.00;
    private static final int HOURLY_HOURS = 40;
    private final List<StaffMember> staffList;

    /**
     * Constructs the list of staff members, read from a file. The file
     * staff.txt must has one line per staff member. The first word in each line
     * is the class name of the staff member. The instance variables to initialize
     * follow on the same line. Tokens must be separated by whitespace.
     */
    public Staff() {

        staffList = new ArrayList<>();

        final Scanner scan;
        try {
            scan = new Scanner(new File("staff.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("could not find staff.txt");
            return;
        }
        scan.useDelimiter("[\t\n]");

        while (scan.hasNext()) {

            final String className = scan.next();
            final StaffMember nextStaff = instantiate(className);

            if (nextStaff == null) {
                return;
            }

            // The instance initializes itself from the file.
            nextStaff.readInstanceData(scan);
            staffList.add(nextStaff);

            // Why do you think I dislike these next two if-statements? A
            // polymorphic call asks the object what to do and lets it answer.
            // These two ask what TYPE the object is and then decide on its
            // behalf, which puts knowledge of every subclass in this one
            // method. Add a third kind of staff member and this file has to
            // change, which is exactly what inheritance was supposed to stop.
            if (nextStaff instanceof Executive) {
                ((Executive) nextStaff).awardBonus(EXECUTIVE_BONUS);
            }
            if (nextStaff instanceof Hourly) {
                ((Hourly) nextStaff).addHours(HOURLY_HOURS);
            }
        }
    }

    /**
     * Creates a StaffMember from the name of its class, using reflection.
     *
     * Reflection is how a program inspects and creates types whose names it
     * only learns at run time. It is what lets staff.txt decide which classes
     * this program instantiates. You will not need it in this course; it is
     * here because it is the only way this file can do what it does.
     *
     * The five things that can go wrong each get their own message, which is
     * the reason this lives in its own method: five catch blocks inside the
     * constructor made that constructor far too long to read.
     *
     * @param className the fully qualified name of the class to instantiate
     * @return a new StaffMember, or null if it could not be created
     */
    private static StaffMember instantiate(final String className) {

        try {
            return (StaffMember) Class.forName(className)
                    .getDeclaredConstructor().newInstance();

        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find class \"" + className + "\"");
        } catch (InstantiationException ex) {
            System.out.println("Class " + className + " cannot be instantiated");
        } catch (IllegalAccessException ex) {
            System.out.println("Definition for class " + className
                    + " cannot be accessed.");
        } catch (NoSuchMethodException ex) {
            System.out.println("Constructor for class " + className
                    + " cannot be found.");
        } catch (InvocationTargetException ex) {
            System.out.println("Constructor for class " + className
                    + " cannot be used.");
        }

        return null;
    }

    /**
     * Pays all staff members.
     */
    public void payday() {
        double amount;

        for (StaffMember staff : staffList) {
            System.out.println(staff);
            amount = staff.pay(); // polymorphic
            if (amount == 0.0) {
                System.out.println("Thanks!");
            } else {
                System.out.println("Paid: " + amount);
            }
            System.out.println("-----------------------------------");
        }
    }
}
