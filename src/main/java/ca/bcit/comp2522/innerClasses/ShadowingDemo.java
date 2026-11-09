package ca.bcit.comp2522.innerClasses;

/**
 * Demonstrates scope and variable shadowing.
 *
 * @author BCIT
 * @version 2026
 */
public class ShadowingDemo {

    /**
     * An instance variable named x, on purpose, so that the inner class can shadow it.
     */
    private final int x = 0;

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String... args) {
        ShadowingDemo st = new ShadowingDemo();
        FirstLevel fl = st.new FirstLevel();
        final int sumFirstFourPrimes = 2 + 3 + 5 + 7;
        fl.methodInFirstLevel(sumFirstFourPrimes);
        final int answer = 42;
        fl.methodInFirstLevel(answer);
    }

    /**
     * An inner class!
     */
    class FirstLevel {

        /**
         * Another x. It shadows the x in the enclosing class.
         */
        private final int x = 1;

        /**
         * Prints some stuff.
         *
         * Checkstyle reports "'x' hides a field" on the parameter below, and
         * it is right to. The violation is deliberate: this file exists to
         * show you what shadowing looks like and how to reach past it with
         * this.x and ShadowingDemo.this.x. In code you actually ship, rename
         * the parameter instead.
         * @param x an integer
         */
        void methodInFirstLevel(final int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowingDemo.x = " + ShadowingDemo.this.x);
            System.out.println("x = " + x);
        }
    }
}
