package ca.bcit.comp2522.dataTypes;

/**
 * Demonstrates overflow and underflow.
 *
 * A primitive type has a fixed width. When a value will not fit, Java does
 * not warn you and does not throw: it wraps around to the other end of the
 * range. Adding one to the largest int gives you the smallest int. Nothing
 * is printed in red. The program simply carries on being wrong.
 *
 * The literals here are the boundary values themselves — 127 is the largest
 * byte, -32,768 the smallest short — so Checkstyle's MagicNumber report on
 * this file is expected and deliberate.
 *
 * @author BCIT
 * @version 2026
 */
public final class Overflow {

    private Overflow() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {

        byte aByte = 127;
        aByte++;
        System.out.println(aByte);

        aByte--;
        System.out.println(aByte);

        short aShort = -32_768;
        aShort--;
        System.out.println(aShort);

        aShort++;
        System.out.println(aShort);

        int anInt = Integer.MAX_VALUE;
        System.out.println(anInt);

        anInt++;
        System.out.println(anInt);

        int someValue = 867_5309;
        long veryBig = someValue;
        System.out.println(veryBig);

        // aByte = veryBig;
        aByte = (byte) veryBig;
        System.out.println(aByte);

    }
}
