package ca.bcit.comp2522.generics;


interface Animal {
    void makeSound();
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

class AnimalBox<T extends Animal> {
    private final T animal;

    AnimalBox(final T animal) {
        this.animal = animal;
    }

    public void soundOff() {
        animal.makeSound();
    }
}

/**
 * Bounds are useful when you want to restrict the types that can be used
 * with generics. For example, you might want to ensure that a generic type
 * implements a certain interface or extends a specific class.
 *
 * @author BCIT
 * @version 2026
 */
public final class WhenToUseBounds {

    private WhenToUseBounds() {
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        AnimalBox<Dog> dogBox = new AnimalBox<>(new Dog());
        dogBox.soundOff();

        AnimalBox<Cat> catBox = new AnimalBox<>(new Cat());
        catBox.soundOff();

        // AnimalBox<Integer> integerBox = new AnimalBox<>(5); // Compile-time error
    }
}
