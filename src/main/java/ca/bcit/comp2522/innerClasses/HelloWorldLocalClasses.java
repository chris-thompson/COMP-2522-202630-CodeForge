package ca.bcit.comp2522.innerClasses;

/**
 * Let's see how to create and use local classes.
 *
 * @author BCIT
 * @version 2026
 */
public class HelloWorldLocalClasses {

    /**
     * This class contains a nested private interface. The interface can be used
     * inside the class to formalize how to greet someone. Only the class can
     * use the interface.
     */
    private interface HelloWorld {
        void greet();
        void greetSomeone(String someone);
    }

    /**
     * Says hello in many fun ways.
     */
    // Checkstyle reports that this method is too long. It is long because
    // it CONTAINS CLASS DEFINITIONS: a local class is declared inside a
    // method body, which is the entire point of this file. The usual
    // remedy for a long method — extract part of it — would delete the
    // thing being demonstrated, so the violation stands deliberately.
    public void sayHello() {

        /* A local class is defined and assigned to a variable.
           It is an implementation of the HelloWorld interface. */
        class EnglishGreeting implements HelloWorld {
            String name = "world";

            @Override
            public void greet() {
                greetSomeone("world");
            }

            @Override
            public void greetSomeone(final String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        /* A local class is defined and assigned to a variable.
           It is an implementation of the HelloWorld interface. */
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            @Override
            public void greet() {
                greetSomeone("tout le monde");
            }

            @Override
            public void greetSomeone(final String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        /* A local class is defined and assigned to a variable.
           It is an implementation of the HelloWorld interface. */
        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";

            @Override
            public void greet() {
                greetSomeone("mundo");
            }

            @Override
            public void greetSomeone(final String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }



    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String... args) {
        HelloWorldLocalClasses myApp = new HelloWorldLocalClasses();
        myApp.sayHello();
    }
}
