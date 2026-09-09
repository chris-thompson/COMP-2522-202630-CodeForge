package ca.bcit.comp2522.students;

/**
 * Demonstrates the use of an aggregate class.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class StudentBody {

    private StudentBody() {
    }

    /**
     * Creates some Address and Student objects and prints them.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final Address school =
                new Address("555 Seymour.", "Vancouver", "BC", "V6B 3H6");

        final Address johnHome =
                new Address("21 Jump Street", "Langley", "BC", "V3A 6K6");
        final Student john = new Student("John", "Smith", johnHome, school);

        final Address marshaHome =
                new Address("123 SomeMain Street", "North Pole", "NU", "H0H 0H0");
        final Student marsha = new Student("Marsha", "Jones", marshaHome, school);

        System.out.println(john);
        System.out.println();
        System.out.println(marsha);
    }
}
