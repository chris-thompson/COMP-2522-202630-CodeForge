package ca.bcit.comp2522.generics;

/**
 * Box.
 *
 * @author BCIT
 * @version 2026
 * @param <T> the type of the object being boxed
 */
public class Box<T> {

    private T t;

    /**
     * Constructor for objects of type Box.
     *
     * @param toBeBoxed the value to box
     */
    public Box(final T toBeBoxed) {
        this.t = toBeBoxed;
    }

    /**
     * Sets the value being boxed.
     * @param toBeBoxed the value to box
     */
    public void set(final T toBeBoxed) {
        this.t = toBeBoxed;
    }

    /**
     * Returns the value boxed.
     * @return t the value boxed
     */
    public T get() {
        return t;
    }
}
