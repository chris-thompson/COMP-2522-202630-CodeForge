package ca.bcit.comp2522.arrays;

/**
 * Demonstrates an array of objects by filling a FilmLibrary.
 *
 * Watch what happens between the two printouts. Nothing in this file mentions
 * the size of the underlying array, and nothing has to: FilmLibrary grows
 * itself when it runs out of room. That is encapsulation doing its job. The
 * caller asks for what it wants and the class works out how to provide it.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class FilmLibraryDemo {

    /** The films the library starts with. */
    private static final Film[] OPENING_CATALOGUE = {
        new Film("Parasite", "Bong Joon-ho", 2019, 24.95, true),
        new Film("Dune: Part Two", "Denis Villeneuve", 2024, 29.99, true),
        new Film("Everything Everywhere All at Once",
                "Daniel Kwan and Daniel Scheinert", 2022, 22.50, true),
        new Film("Spider-Man: Across the Spider-Verse",
                "Joaquim Dos Santos", 2023, 19.95, false),
        new Film("Arrival", "Denis Villeneuve", 2016, 15.95, false),
    };

    /** Two more films, added after the library has already been printed. */
    private static final Film[] LATER_ARRIVALS = {
        new Film("Past Lives", "Celine Song", 2023, 21.99, false),
        new Film("The Grand Budapest Hotel", "Wes Anderson", 2014, 17.50, true),
    };

    private FilmLibraryDemo() {
    }

    /**
     * Creates a FilmLibrary, adds some films to it, and prints it twice.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {

        final FilmLibrary films = new FilmLibrary();

        for (final Film film : OPENING_CATALOGUE) {
            films.addFilm(film);
        }

        System.out.println(films);

        // Two more, added after the first printout, so you can see the count
        // and the total cost both change.
        for (final Film film : LATER_ARRIVALS) {
            films.addFilm(film);
        }

        System.out.println(films);
    }
}
