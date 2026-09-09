package ca.bcit.comp2522.dataStructures.linkedList;

/**
 * Represents a single magazine.
 *
 * @author BCIT
 * @version 2026
 */
public final class Magazine {

    private final String title;

    /**
     * Constructs a new Magazine object with the specified title.
     *
     * @param newTitle The title of the magazine
     */
    public Magazine(final String newTitle) {
        title = newTitle;
    }

    /**
     * Returns a description of this Magazine.
     *
     * This implementation reports the values of the fields declared in
     * Magazine. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Magazine as a String
     */
    @Override
    public String toString() {
        return "Magazine{" + "title='" + title + '\'' + '}';
    }
}

