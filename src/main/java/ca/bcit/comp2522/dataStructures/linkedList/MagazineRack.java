package ca.bcit.comp2522.dataStructures.linkedList;

/**
 * Driver to exercise the MagazineList collection.
 *
 * @author BCIT
 * @version 2026
 */
public final class MagazineRack {

    private MagazineRack() {
    }

    /**
     * Creates a MagazineList object, adds several magazines to the list, then
     * prints it.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        MagazineList rack = new MagazineList();

        rack.add(new Magazine("National Geographic"));
        rack.add(new Magazine("The New Yorker"));
        rack.add(new Magazine("Communications of the ACM"));
        rack.add(new Magazine("Cosmo"));
        rack.add(new Magazine("GQ"));

        System.out.println(rack);
    }
}

