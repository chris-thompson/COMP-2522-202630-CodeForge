package ca.bcit.comp2522.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Film, which is a value class.
 *
 * A value class is one whose identity is entirely its contents: two Films with
 * the same title, director, year, cost and format ARE the same film as far as
 * the program is concerned. That is what equals and hashCode exist to express,
 * and it is most of what there is to test here.
 *
 * @author BCIT
 * @version 2026
 */
class FilmTest {

    private static final double COST = 24.95;

    private Film film;

    @BeforeEach
    void setUp() {
        film = new Film("Parasite", "Bong Joon-ho", 2019, COST, true);
    }

    @Test
    void getTitleReturnsTheTitle() {
        assertEquals("Parasite", film.getTitle());
    }

    @Test
    void getDirectorReturnsTheDirector() {
        assertEquals("Bong Joon-ho", film.getDirector());
    }

    @Test
    void getYearReturnsTheYear() {
        assertEquals(2019, film.getYear());
    }

    @Test
    void getCostReturnsTheCost() {
        assertEquals(COST, film.getCost());
    }

    @Test
    void isUltraHdIsTrueForAFourKEdition() {
        assertTrue(film.isUltraHd());
    }

    @Test
    void isUltraHdIsFalseForAStandardEdition() {
        final Film standard = new Film("Arrival", "Denis Villeneuve", 2016, COST, false);
        assertFalse(standard.isUltraHd());
    }

    @Test
    void toStringContainsTheTitle() {
        assertTrue(film.toString().contains("Parasite"));
    }

    @Test
    void twoFilmsWithIdenticalFieldsAreEqual() {
        assertEquals(new Film("Parasite", "Bong Joon-ho", 2019, COST, true), film);
    }

    @Test
    void filmsDifferingOnlyByYearAreNotEqual() {
        assertNotEquals(new Film("Parasite", "Bong Joon-ho", 2020, COST, true), film);
    }

    @Test
    void filmsDifferingOnlyByFormatAreNotEqual() {
        assertNotEquals(new Film("Parasite", "Bong Joon-ho", 2019, COST, false), film);
    }

    @Test
    void equalFilmsShareAHashCode() {
        assertEquals(new Film("Parasite", "Bong Joon-ho", 2019, COST, true).hashCode(),
                film.hashCode());
    }
}
