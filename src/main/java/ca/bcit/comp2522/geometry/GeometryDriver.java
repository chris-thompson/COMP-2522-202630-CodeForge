package ca.bcit.comp2522.geometry;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Asks for the dimensions of three solids and reports their properties.
 *
 * The interesting thing here is what the driver does NOT do. It never
 * calculates a surface area or a volume. It reads numbers, hands them to a
 * Sphere, a Cube or a Cone, and asks that object for the answer. Every formula
 * lives with the shape it belongs to.
 *
 * That is the division of labour you are aiming for: the driver knows about
 * the user, and each model class knows about itself.
 *
 * @author BCIT
 * @version 2026
 */
public final class GeometryDriver {

    /** Three decimal places is plenty for this. */
    private static final DecimalFormat FORMAT = new DecimalFormat("#.###");

    private GeometryDriver() {
    }

    /**
     * Reads a Sphere from the user and reports on it.
     *
     * @param scan the Scanner to read from
     */
    private static void doSphere(final Scanner scan) {

        System.out.println("Enter the radius of a sphere:");
        final double radius = scan.nextDouble();
        System.out.println("Enter the X-coordinate of a sphere:");
        final double x = scan.nextDouble();
        System.out.println("Enter the Y-coordinate of a sphere:");
        final double y = scan.nextDouble();
        System.out.println("Enter the Z-coordinate of a sphere:");
        final double z = scan.nextDouble();

        final Sphere sphere = new Sphere(radius, x, y, z);
        System.out.println("The SA = " + FORMAT.format(sphere.getSurfaceArea()));
        System.out.println("The V  = " + FORMAT.format(sphere.getVolume()));
    }

    /**
     * Reads a Cube from the user and reports on it.
     *
     * @param scan the Scanner to read from
     */
    private static void doCube(final Scanner scan) {

        System.out.println("Enter the edge length of a cube:");
        final double edgeLength = scan.nextDouble();
        System.out.println("Enter the X-coordinate of a cube:");
        final double x = scan.nextDouble();
        System.out.println("Enter the Y-coordinate of a cube:");
        final double y = scan.nextDouble();
        System.out.println("Enter the Z-coordinate of a cube:");
        final double z = scan.nextDouble();

        final Cube cube = new Cube(edgeLength, x, y, z);
        System.out.println("The SA = " + FORMAT.format(cube.getSurfaceArea()));
        System.out.println("The V  = " + FORMAT.format(cube.getVolume()));
        System.out.println("The FD = " + FORMAT.format(cube.getFaceDiagonal()));
        System.out.println("The SD = " + FORMAT.format(cube.getSpaceDiagonal()));
    }

    /**
     * Reads a Cone from the user and reports on it.
     *
     * @param scan the Scanner to read from
     */
    private static void doCone(final Scanner scan) {

        System.out.println("Enter the radius of a cone:");
        final double radius = scan.nextDouble();
        System.out.println("Enter the height of a cone:");
        final double height = scan.nextDouble();

        final Cone cone = new Cone(radius, height);
        System.out.println("The V  = " + FORMAT.format(cone.getVolume()));
        System.out.println("The SA = " + FORMAT.format(cone.getSurfaceArea()));
        System.out.println("The SH = " + FORMAT.format(cone.getSlantHeight()));
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {

        final Scanner scan = new Scanner(System.in);

        doSphere(scan);
        doCube(scan);
        doCone(scan);

        scan.close();
    }
}
