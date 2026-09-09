package ca.bcit.comp2522.inheritance.introToInheritance.shapes;

/**
 * Let's play with Shapes.
 *
 * @author BCIT
 * @version 2026
 */
public final class Driver {

    private Driver() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final int sideLength = 9;
        final Cube myCube = new Cube(sideLength);
        final double radius = 9.8;
        final Sphere mySphere = new Sphere(radius);
        final int cylinderRadius = 5;
        final int cylinderHeight = 5;
        Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
        System.out.println(myCube);
        System.out.println(mySphere);
        System.out.println(cylinder);

        Shape myOtherCube = new Cube(sideLength);
        Cube myAlias = (Cube) myOtherCube;
        System.out.println(myAlias);
    }
}
