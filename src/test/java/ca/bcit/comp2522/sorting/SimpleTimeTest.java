package ca.bcit.comp2522.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests SimpleTime, including its documented clamping behaviour.
 *
 * SimpleTime cannot throw. Exceptions are a Week 09 topic and this class
 * belongs to an earlier part of the course, so instead of rejecting an
 * out-of-range value it clamps to a documented default of zero. That is a
 * legitimate design for a class written before exceptions are available, and
 * the important word is DOCUMENTED: because the behaviour is written down, it
 * is part of the contract, so it is tested here rather than left to chance.
 *
 * This is the pattern your Labs 00 to 06 use, and Lab 07 is where the same
 * class gets retrofitted to throw instead.
 *
 * @author BCIT
 * @version 2026
 */
class SimpleTimeTest {

    @Test
    void theNoArgumentConstructorGivesMidnight() {
        assertEquals(0, new SimpleTime().getHour());
    }

    @Test
    void theHourIsStoredAsGiven() {
        assertEquals(9, new SimpleTime(9, 30, 15).getHour());
    }

    @Test
    void theMinuteIsStoredAsGiven() {
        assertEquals(30, new SimpleTime(9, 30, 15).getMinute());
    }

    @Test
    void theSecondIsStoredAsGiven() {
        assertEquals(15, new SimpleTime(9, 30, 15).getSecond());
    }

    @Test
    void theLastValidHourIsAccepted() {
        // The boundary: 23 is in range, 24 is not.
        assertEquals(23, new SimpleTime(23, 0, 0).getHour());
    }

    @Test
    void anHourAtTheUpperBoundIsClampedAsDocumented() {
        assertEquals(0, new SimpleTime(24, 0, 0).getHour());
    }

    @Test
    void aMinuteAtTheUpperBoundIsClampedAsDocumented() {
        assertEquals(0, new SimpleTime(0, 60, 0).getMinute());
    }

    @Test
    void toUniversalStringPadsEveryFieldToTwoDigits() {
        assertEquals("09:05:03", new SimpleTime(9, 5, 3).toUniversalString());
    }

    @Test
    void middayIsPrintedAsTwelvePm() {
        assertEquals("12:00:00 PM", new SimpleTime(12, 0, 0).toString());
    }

    @Test
    void midnightIsPrintedAsTwelveAm() {
        assertEquals("12:00:00 AM", new SimpleTime(0, 0, 0).toString());
    }

    @Test
    void anAfternoonHourIsPrintedOnTheTwelveHourClock() {
        assertEquals("1:30:00 PM", new SimpleTime(13, 30, 0).toString());
    }
}
