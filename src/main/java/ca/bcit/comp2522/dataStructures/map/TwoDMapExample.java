package ca.bcit.comp2522.dataStructures.map;

/**
 * TwoDMapExample. Can you solve this brainteaser?
 *
 * @author BCIT
 * @version 2026
 */
public final class TwoDMapExample {

    private TwoDMapExample() {
    }

    /**
     * Drives the program. Complete the program to produce the required output.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        // Create Map called student [Province, Map[City, Id]]

        // Create Map called BC [City, Id]

        // Add 2 students to BC Map:
        // 1. "Vancouver", "A00012345"
        // 2. "New West", "A00067891"

        // Add the BC Map to the student code.maps

        // Create Map called ON [City, Id] (or reuse object reference)

        // Add 2 students to ON Map:
        // 1. "Toronto", "A00038234"
        // 2. "Ottawa","A00000123"

        // Add the ON Map to the student code.maps

        // Expected output:
        // student prov = BC {Vancouver=A00012345, New West=A00067891}
        // student prov = ON {Ottawa=A00000123, Toronto=A00038234}
        // System.out.println("student prov = BC " + student.get("BC"));
        // System.out.println("student prov = ON " + student.get("ON"));
    }
}
