package ca.bcit.comp2522.helloWorld;

/**
 * HelloWorld.
 *
 * @author BCIT
 * @version 2026
 */
public final class HelloWorld {

    private HelloWorld() { }

    /**
     * Drives the program.
     * @param args unused array of String
     */
    public static void main(final String[] args) {

        final String message = "Hello world!";
        System.out.println(message);

        String emptyString = "";
        System.out.println(emptyString);

        String anotherString = new String("Long live the Oxford comma!");
        System.out.println(anotherString);

        String noString = null;
        System.out.println(noString);
        noString = "I have a value now";
        System.out.println(noString);

        final int theAnswerToEverything = 42;
        // theAnswerToEverything = null;
        System.out.println(theAnswerToEverything);

        final double goldenRatio = 1.6180339887498948482;
        System.out.println(goldenRatio);

        final int classSize = 5;
        for (int i = 0; i < classSize; i++) {
            System.out.println("Welcome");
        }

    }
} // end of the HelloWorld class
