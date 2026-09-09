package ca.bcit.comp2522.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests FilmLibrary, and in particular that it grows.
 *
 * The interesting behaviour in FilmLibrary is the one you cannot see from
 * outside: when the internal array fills up, the class quietly allocates a
 * bigger one and copies everything across. A test is the only way to be
 * confident that it works, because from the caller's point of view nothing
 * happens at all — which is exactly the point.
 *
 * @author BCIT
 * @version 2026
 */
class FilmLibraryTest {

    private static final double COST = 19.99;

    private FilmLibrary library;

    @BeforeEach
    void setUp() {
        library = new FilmLibrary();
    }

    private static Film sampleFilm(final int index) {
        return new Film("Film " + index, "Director " + index, 2020, COST, false);
    }

    @Test
    void aNewLibraryHoldsNothing() {
        assertEquals(0, library.getCount());
    }

    @Test
    void aNewLibraryHasCostNothing() {
        assertEquals(0.0, library.getTotalCost());
    }

    @Test
    void addingOneFilmMakesTheCountOne() {
        library.addFilm(sampleFilm(1));
        assertEquals(1, library.getCount());
    }

    @Test
    void addingByFieldsAccumulatesTheTotalCost() {
        library.addFilm("Dune", "Denis Villeneuve", 2021, COST, true);
        assertEquals(COST, library.getTotalCost());
    }

    @Test
    void countIsCorrectAtExactlyTheDefaultCapacity() {
        // The boundary: the array is full but has not had to grow yet.
        for (int i = 0; i < FilmLibrary.DEFAULT_SIZE; i++) {
            library.addFilm(sampleFilm(i));
        }
        assertEquals(FilmLibrary.DEFAULT_SIZE, library.getCount());
    }

    @Test
    void theLibraryGrowsPastItsDefaultCapacity() {
        // One past the boundary, which is what forces increaseSize to run.
        final int oneTooMany = FilmLibrary.DEFAULT_SIZE + 1;
        for (int i = 0; i < oneTooMany; i++) {
            library.addFilm(sampleFilm(i));
        }
        assertEquals(oneTooMany, library.getCount());
    }
}
