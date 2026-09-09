package ca.bcit.comp2522.serializing;

import java.io.Serial;
import java.io.Serializable;

/**
 * A simple Person.
 *
 * @author BCIT
 * @version 2026
 */
public final class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // Recommended for serialization
    private final String name;
    private final int age;

    /**
     * Create an object of type Person.
     * @param name a string
     * @param age an integer
     */
    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns a description of this Person.
     *
     * This implementation reports the values of the fields declared in
     * Person. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Person as a String
     */
    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", age=" + age + '}';
    }
}

