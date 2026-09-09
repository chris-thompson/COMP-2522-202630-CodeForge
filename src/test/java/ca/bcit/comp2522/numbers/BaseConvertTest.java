package ca.bcit.comp2522.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests BaseConvert.toBase.
 *
 * toBase is a pure function: same input, same output, no state, no input, no
 * output. Pure functions are the easiest things in the world to test, which is
 * a good reason to write them whenever you can. Compare this file with trying
 * to test the old version of BaseConvert, where the conversion was tangled up
 * with reading from the keyboard inside main.
 *
 * @author BCIT
 * @version 2026
 */
class BaseConvertTest {

    @Test
    void zeroIsZeroInEveryBase() {
        assertEquals("0", BaseConvert.toBase(0, 2));
    }

    @Test
    void aNumberSmallerThanTheBaseIsASingleDigit() {
        assertEquals("5", BaseConvert.toBase(5, 8));
    }

    @Test
    void eightInBaseTwoIsOneThousand() {
        assertEquals("1000", BaseConvert.toBase(8, 2));
    }

    @Test
    void twentySevenInBaseThreeIsOneThousand() {
        assertEquals("1000", BaseConvert.toBase(27, 3));
    }

    @Test
    void aValueIsUnchangedWhenConvertedToBaseTen() {
        // The Javadoc documents that an out-of-range base falls back to base
        // ten rather than throwing, so this fallback is part of the contract.
        assertEquals("255", BaseConvert.toBase(255, 10));
    }

    @Test
    void theSmallestAllowedBaseIsHandled() {
        assertEquals("11", BaseConvert.toBase(3, 2));
    }

    @Test
    void theLargestAllowedBaseIsHandled() {
        assertEquals("11", BaseConvert.toBase(10, 9));
    }
}
