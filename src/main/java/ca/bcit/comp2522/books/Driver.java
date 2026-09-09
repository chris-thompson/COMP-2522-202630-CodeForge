package ca.bcit.comp2522.books;

/**
 * Tests the Book class.
 *
 * @author BCIT
 * @version 2026
 */
public final class Driver {

    private Driver() { }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        final Book myBook = new Book();
        System.out.println(myBook);

        final int enormousNovelLength = 700;
        final Book anotherBook = new Book("Homer", "Iliad", enormousNovelLength);
        System.out.println(anotherBook);

    }
}
