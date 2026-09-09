package ca.bcit.comp2522.inheritance.introToInheritance.polymorphism101;

/**
 * Polymorphism demo.
 *
 * @author BCIT
 * @version 2026
 */
public final class Polymorphism1 {

    private Polymorphism1() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final A aObject;
        final B bObject;
        final A anInterestingObject;

        aObject = new A();
        bObject = new B();
        anInterestingObject = new B();

        aObject.foo();
        System.out.println("---");
        bObject.foo();
        System.out.println("---");
        anInterestingObject.foo();
        System.out.println("---");
        bObject.bar();
        System.out.println("---");
        // anInterestingObject.bar(); <- will this compile?
    }
}

/**
 * A is the superclass.
 */
class A {
    public void foo() {
        System.out.println("A foo()");
    }
}

/**
 * B is a subclass of A.
 */
class B extends A {
    @Override
    public void foo() {
        System.out.println("B foo()");
    }

    public void bar() {
        System.out.println("B bar()");
    }
}
