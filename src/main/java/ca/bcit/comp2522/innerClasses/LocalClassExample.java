package ca.bcit.comp2522.innerClasses;

/**
 * This is an example of a local class. Hold on to your hat. This is very cool.
 *
 * @author BCIT
 * @version 2026
 */
public final class LocalClassExample {

    /**
     * Ooh! A regex!
     */
    public static final String REGULAR_EXPRESSION = "[^0-9]";

    private LocalClassExample() {
    }

    /**
     * Validates a phone number.
     *
     * @param acceptablePattern a String
     * @param phoneNumber       to be tested as a String
     */
    // Checkstyle reports that this method is too long. It is long because
    // it CONTAINS CLASS DEFINITIONS: a local class is declared inside a
    // method body, which is the entire point of this file. The usual
    // remedy for a long method — extract part of it — would delete the
    // thing being demonstrated, so the violation stands deliberately.
    public static void validatePhoneNumber(final String acceptablePattern,
                                           final String phoneNumber) {

        final int numberLength = 10;

        /*
         * A local class! A class defined inside a method for immediate use.
         */
        class PhoneNumber {

            private final String formattedPhoneNumber;

            /**
             * Constructs a PhoneNumber object
             * @param phoneNumber a String
             */
            PhoneNumber(final String phoneNumber) {
                // numberLength = 7; // What happens if we uncomment this? Why does that happen?

                String currentNumber = phoneNumber.replaceAll(REGULAR_EXPRESSION, "");
                if (currentNumber.length() == numberLength) {
                    formattedPhoneNumber = currentNumber;
                } else {
                    formattedPhoneNumber = null;
                }
            }

            /**
             * Returns the formatted number as a String.
             * @return phoneNumber formatted as a String
             */
            public String getNumber() {
                return formattedPhoneNumber;
            }

            /**
             * Prints the original numbers
             */
            public void printOriginalNumbers() {
                System.out.println("Original numbers are "
                        + acceptablePattern + " and " + phoneNumber);

            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(acceptablePattern);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber);

        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null) {
            System.out.println("First number is invalid");
        } else {
            System.out.println("First number is " + myNumber1.getNumber());
        }

        if (myNumber2.getNumber() == null) {
            System.out.println("Second number is invalid");
        } else {
            System.out.println("Second number is " + myNumber2.getNumber());
        }
    }

    /**
     * Drives the program.
     * @param args unused.
     */
    public static void main(final String... args) {
        validatePhoneNumber("12A-456-7890", "123-222-7890");
    }
}
