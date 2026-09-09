package ca.bcit.comp2522.inheritance.introToInheritance.polymorphism101;

/**
 * Polymorphism demo.
 *
 * @author BCIT
 * @version 2026
 */
public final class Polymorphism2 {

    private Polymorphism2() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final C cc = new C();
        final C cd = new D();
        final C ce = new E();
        final D d = new D();
        final E e = new E();

        cc.foo();
        System.out.println("---");
        cd.foo();
        System.out.println("---");
        ce.foo();
        System.out.println("---");
        d.foo();
        System.out.println("---");
        e.foo();
    }
}

/**
 * C.
 */
class C {
    void foo() {
        System.out.println("C foo()");
        bar();
    }

    void bar() {
        System.out.println("C bar()");
    }
}

/**
 * D extends C.
 */
class D extends C {
    @Override
    void foo() {
        System.out.println("D food()");
    }

    @Override
    void bar() {
        System.out.println("D bar()");
    }
}

/**
 * E extends C.
 */
class E extends C {
    @Override
    void bar() {
        System.out.println("E bar()");
    }
}
