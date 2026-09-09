package ca.bcit.comp2522.exceptions;

import java.util.Scanner;

/**
 * Demonstrates the use of a try-catch block.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class ProductCodes {
    /**
     * District numbers greater than this are disallowed.
     */
    public static final int MAX_DISTRICT = 2000;

    /**
     * The zone is at this index of the product code.
     */
    public static final int ZONE_INDEX = 9;

    /**
     * The district begins at this index of the the product code.
     */
    public static final int DISTRICT_BEG = 3;

    /**
     * The district ends at this index of the the product code.
     */
    public static final int DISTRICT_END = 7;

    private ProductCodes() {
    }

    /**
     * Examine the use of exception handling.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        System.out.print("Enter product code (XXX to quit): ");
        final Scanner scan = new Scanner(System.in);
        String code = scan.nextLine();
        int valid = 0;
        int banned = 0;
        while (!code.equalsIgnoreCase("XXX")) {
            try {
                char zone = code.charAt(ZONE_INDEX);
                int district = Integer.parseInt(
                        code.substring(DISTRICT_BEG, DISTRICT_END));
                valid++;
                if (zone == 'R' && district > MAX_DISTRICT) {
                    banned++;
                }
            } catch (StringIndexOutOfBoundsException exception) {
                System.out.println("Improper code length: " + code);
            } catch (NumberFormatException exception) {
                System.out.println("District is not numeric: " + code);
            }

            System.out.print("Enter product code (XXX to quit): ");
            code = scan.nextLine();
        }
        scan.close();
        System.out.println("# of valid codes entered: " + valid);
        System.out.println("# of banned codes entered: " + banned);
    }
}
