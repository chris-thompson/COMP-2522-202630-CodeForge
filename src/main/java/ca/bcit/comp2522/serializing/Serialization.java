package ca.bcit.comp2522.serializing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Demonstrate simple serialization.
 *
 * @author BCIT
 * @version 2026
 */
public final class Serialization {

    private Serialization() {
    }

    /**
     * Drive the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final int age = 30;
        Person person = new Person("Taro Tanaka", age);
        String filename = "person.ser";

        // Serialize the person object to a file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(person);
            System.out.println("Object has been serialized");
        } catch (IOException e) {
            System.out.println("IOException is caught during serialization");
            e.printStackTrace();
        }

        // Deserialize the person object from the file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Person deserializedPerson = (Person) in.readObject();
            System.out.println("Object has been deserialized");
            System.out.println(deserializedPerson);
        } catch (IOException e) {
            System.out.println("IOException is caught during deserialization");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught");
            e.printStackTrace();
        }
    }
}

