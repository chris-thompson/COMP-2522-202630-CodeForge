package ca.bcit.comp2522.exceptions;

public class AgeReader {
    static int parseAge(final String text) throws BadRecordException {
        try {
            return Integer.parseInt(text);
        } catch (final NumberFormatException cause) {
            throw new BadRecordException("age is not a number: " + text, cause);
        }
    }

    public static void main(final String[] args) throws BadRecordException {
        System.out.println(parseAge("forty"));
    }
}
