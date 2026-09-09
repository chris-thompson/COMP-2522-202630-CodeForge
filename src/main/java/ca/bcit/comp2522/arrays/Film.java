package ca.bcit.comp2522.arrays;

import java.text.NumberFormat;
import java.util.Objects;

/**
 * Represents one film in a library.
 *
 * This class exists mainly so that FilmLibrary has something to hold. It is
 * also a reasonable model of what a well-behaved value class looks like: every
 * instance variable is private and final, the only way to set them is through
 * the constructor, and equals, hashCode and toString are all written and all
 * agree with one another about which fields matter.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Film {

    private final String title;
    private final String director;
    private final int year;
    private final double cost;
    private final boolean ultraHd;

    /**
     * Constructs a new Film with the specified information.
     *
     * @param title    the film's title
     * @param director the director's name
     * @param year     the year of release
     * @param cost     the purchase price in dollars
     * @param ultraHd  true if this is a 4K Ultra HD edition
     */
    public Film(final String title,
                final String director,
                final int year,
                final double cost,
                final boolean ultraHd) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.cost = cost;
        this.ultraHd = ultraHd;
    }

    /**
     * Returns this Film's title.
     *
     * @return this Film's title as a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns this Film's director.
     *
     * @return this Film's director as a String
     */
    public String getDirector() {
        return director;
    }

    /**
     * Returns this Film's year of release.
     *
     * @return this Film's year as an int
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns this Film's cost.
     *
     * @return this Film's cost as a double
     */
    public double getCost() {
        return cost;
    }

    /**
     * Returns true if this Film is a 4K Ultra HD edition.
     *
     * @return true if this is a 4K edition, otherwise false
     */
    public boolean isUltraHd() {
        return ultraHd;
    }

    /**
     * Returns a description of this Film.
     *
     * @return this Film as a String
     */
    @Override
    public String toString() {
        final NumberFormat currency = NumberFormat.getCurrencyInstance();
        final StringBuilder builder = new StringBuilder("Film{");
        builder.append("title='").append(getTitle()).append('\'');
        builder.append(", director='").append(getDirector()).append('\'');
        builder.append(", year=").append(getYear());
        builder.append(", cost=").append(currency.format(getCost()));
        builder.append(", ultraHd=").append(isUltraHd());
        builder.append('}');
        return builder.toString();
    }

    /**
     * Compares this Film with another object for equality.
     *
     * All five fields must match. Objects.equals is used for the two String
     * fields because it handles null on either side for you; writing the null
     * checks out by hand is where this method used to be forty lines long.
     *
     * @param object the object to compare with this Film
     * @return true if object is a Film with identical fields
     */
    @Override
    public boolean equals(final Object object) {

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Film film = (Film) object;

        return year == film.year
                && Double.compare(cost, film.cost) == 0
                && ultraHd == film.ultraHd
                && Objects.equals(title, film.title)
                && Objects.equals(director, film.director);
    }

    /**
     * Returns a hash code for this Film.
     *
     * Built from exactly the fields equals compares, which is what keeps the
     * two methods consistent.
     *
     * @return a hash code for this Film
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, director, year, cost, ultraHd);
    }
}
