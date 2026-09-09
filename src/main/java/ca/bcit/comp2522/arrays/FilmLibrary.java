package ca.bcit.comp2522.arrays;

import java.text.NumberFormat;
import java.util.Arrays;

/**
 * Represents a library of films, stored in a plain array.
 *
 * The interesting part of this class is increaseSize. An array in Java has a
 * fixed length: once you have made one you cannot make it bigger. So when the
 * library fills up, this class allocates a second, larger array, copies
 * everything across, and forgets the first one. That is exactly what ArrayList
 * does for you behind the scenes, and doing it once by hand is the best way to
 * understand what you are getting when you stop doing it by hand.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class FilmLibrary {

    /**
     * Default collection size.
     */
    public static final int DEFAULT_SIZE = 100;

    private Film[] collection;
    private int count;
    private double totalCost;

    /**
     * Constructs a new empty FilmLibrary of default size.
     */
    public FilmLibrary() {
        collection = new Film[DEFAULT_SIZE];
        count = 0;
        totalCost = 0.0;
    }

    /**
     * Adds a new Film to this FilmLibrary. Creates a new Film using the
     * specified information and adds it.  Increases the size of the
     * collection array if necessary.
     *
     * @param title    the film's title
     * @param director the director's name
     * @param year     the year of release
     * @param cost     the purchase price in dollars
     * @param ultraHd  true if this is a 4K Ultra HD edition
     */
    public void addFilm(final String title,
                        final String director,
                        final int year,
                        final double cost,
                        final boolean ultraHd) {
        if (count == collection.length) {
            increaseSize();
        }
        collection[count] = new Film(title, director, year, cost, ultraHd);
        totalCost += cost;
        count++;
    }

    /**
     * Adds the specified Film to this collection.
     *
     * @param film the Film to add
     */
    public void addFilm(final Film film) {
        if (count == collection.length) {
            increaseSize();
        }
        collection[count] = film;
        count++;
    }

    /**
     * Returns the number of DVDs in this collection.
     *
     * @return count as an int
     */
    public int getCount() {
        return count;
    }

    /**
     * Returns the total cost of the DVDs in this collection.
     *
     * @return totalCost as a double
     */
    public double getTotalCost() {
        return totalCost;
    }

    /*
     * Increases the capacity of the collection by creating a
     * larger array and copying the existing collection into it.
     */
    private void increaseSize() {
        final Film[] temp = new Film[collection.length * 2];
        System.arraycopy(collection, 0, temp, 0, collection.length);
        collection = temp;
    }

    /**
     * Returns a description of this FilmLibrary.
     *
     * This implementation reports the values of the fields declared in
     * FilmLibrary. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this FilmLibrary as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("FilmLibrary{");
        if (collection == null) {
            sb.append("collection=").append("null");
        } else {
            sb.append("collection=").append(Arrays.asList(collection));
        }
        sb.append(", count=").append(getCount());
        final NumberFormat fmt = NumberFormat.getCurrencyInstance();
        sb.append(", totalCost=").append(fmt.format(getTotalCost()));
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this FilmLibrary with another object for equality.
     *
     * This implementation compares the fields declared in FilmLibrary and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this FilmLibrary
     * @return true if object is equal to this FilmLibrary
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        FilmLibrary that = (FilmLibrary) object;

        if (getCount() != that.getCount()) {
            return false;
        }
        if (Double.compare(getTotalCost(), that.getTotalCost()) != 0) {
            return false;
        }
        return Arrays.equals(collection, that.collection);
    }

    /**
     * Returns a hash code for this FilmLibrary.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this FilmLibrary
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Arrays.hashCode(collection);
        final int usefulPrime = 31;
        result = usefulPrime * result + getCount();
        temp = Double.doubleToLongBits(getTotalCost());
        final int bitShift = 32;
        result = usefulPrime * result + (int) (temp ^ (temp >>> bitShift));
        return result;
    }
}
