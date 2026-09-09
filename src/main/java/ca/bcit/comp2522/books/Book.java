package ca.bcit.comp2522.books;

/**
 * Represents a book.
 *
 * @author BCIT
 * @version 2026
 */
public final class Book {

    /**
     * Default author name.
     */
    public static final String DEFAULT_AUTHOR = "Jane Doe";

    /**
     * Default title.
     */
    public static final String DEFAULT_TITLE = "The Book";

    /**
     * Default number of page.
     */
    public static final int MINIMUM_PAGES = 0;

    private final String author;
    private final String title;
    private final int pages;

    /**
     * Constructs an object of type Book.
     */
    public Book() {
        this(DEFAULT_AUTHOR, DEFAULT_TITLE, MINIMUM_PAGES);
    }

    /**
     * Constructs an object of type Book.
     *
     * @param author a String
     * @param title  a String
     */
    public Book(final String author, final String title) {
        this(author, title, MINIMUM_PAGES);
    }

    /**
     * Constructs an object of type Book.
     *
     * @param author a String
     * @param title  a String
     * @param pages  a positive int
     */
    public Book(final String author, final String title, final int pages) {
        this.author = author;
        this.title = title;
        this.pages = Math.max(pages, MINIMUM_PAGES);
    }

    /**
     * Returns the number of pages as an int.
     *
     * @return pages as an int
     */
    public int getPages() {
        return pages;
    }

    /**
     * Returns the author as a String.
     *
     * @return author as a String
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the title as a String.
     *
     * @return title as a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns a String representation of this object.
     *
     * @return description as a String.
     */
    @Override
    public String toString() {
        return "Book{"
                + "author='"
                + getAuthor() + '\''
                + ", title='" + getTitle() + '\''
                + ", pages=" + getPages() + '}';
    }

    /**
     * Compares this Book with another object for equality.
     *
     * This implementation compares the fields declared in Book and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Book
     * @return true if object is equal to this Book
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Book book = (Book) object;

        if (getPages() != book.getPages()) {
            return false;
        }
        if (getAuthor() != null) {
            if (!getAuthor().equals(book.getAuthor())) {
                return false;
            }
        } else {
            if (book.getAuthor() != null) {
                return false;
            }
        }
        if (getTitle() != null) {
            return getTitle().equals(book.getTitle());
        }
        return book.getTitle() == null;
    }

    /**
     * Returns a hash code for this Book.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Book
     */
    @Override
    public int hashCode() {
        int result;
        if (getAuthor() != null) {
            result = getAuthor().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        if (getTitle() != null) {
            result = usefulPrime * result + getTitle().hashCode();
        } else {
            result = usefulPrime * result;
        }
        result = usefulPrime * result + getPages();
        return result;
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        final int quantity = 10;
        for (int i = 0; i < quantity; ++i) {
            System.out.println(new Book());
        }

        final int decentNovelLength = 300;
        Book allParameters = new Book("Jane Doe", "The Great Canadian Novel", decentNovelLength);
        Book twoParameters = new Book("Jane Doe", "The Great Canadian Novel");
        System.out.println(allParameters);
        System.out.println(twoParameters);
    }
}
