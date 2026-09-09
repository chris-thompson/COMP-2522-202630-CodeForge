package ca.bcit.comp2522.innerClasses;

/**
 * Worker has a constructor that accepts and prints an integer. It also
 * declares an abstract method.
 *
 * @author BCIT
 */
abstract class Worker {

    /**
     * Creates an object of type Worker.
     * @param number an integer
     */
    Worker(final int number) {
        System.out.println("Worker constructor, number = " + number);
    }

    /**
     * An abstract method to be overridden by a subclass of Base.
     */
    public abstract void doSomething();
}

/**
 * This class returns an anonymous instance of an implementation of Worker.
 *<p>
 * Let's say that again. This class contains a static method that returns an instance of Worker. But
 * Worker is abstract! So it's actually returning a spur of the moment, right-here-right-now
 * implementation of the Worker abstract class.
 *<p>
 * Pay attention to the constructor. The Worker constructor accepts a
 * parameter. We pass the parameter
 * to the constructor (the first line of getBase) and then describe the anonymous class that extends
 * Worker.
 *
 * @author BCIT
 * @version 2026
 */
public final class AnonymousConstructor {

    private AnonymousConstructor() {

    }

    /**
     * Returns an instance of the Worker class. Well, actually it returns a freshly made instance
     * of an implementation of the Worker class.
     * @param number an integer
     * @return anonymousBase an instance of the Worker class.
     */
    static Worker getWorker(final int number) {

        return new Worker(number) {
            // We can do stuff that initializes the new object inside a block like this
            {
                System.out.println("Inside instance initializer");
            }

            /**
             * An implementation specific to this instance being created and returned right now.
             */
            @Override
            public void doSomething() {
                System.out.println("Executing anonymous doSomething() "
                        + "inside a Worker storing " + number);
            }
        };
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final int aPerfectNumber = 28;
        Worker worker = getWorker(aPerfectNumber);
        worker.doSomething();

        final int smallestAchillesNumber = 72;
        Worker anotherWorker = getWorker(smallestAchillesNumber);
        anotherWorker.doSomething();
    }
}
