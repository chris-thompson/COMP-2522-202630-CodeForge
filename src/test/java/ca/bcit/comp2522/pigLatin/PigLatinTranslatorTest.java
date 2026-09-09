package ca.bcit.comp2522.pigLatin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests PigLatinTranslator.
 *
 * The translator has three branches, and this file has one test for each:
 * a word starting with a vowel, a word starting with a two-letter blend, and
 * an ordinary word starting with a single consonant. "All branches covered" is
 * one of the things your lab checklists mean by a complete test suite, and
 * three branches means at least three tests.
 *
 * @author BCIT
 * @version 2026
 */
class PigLatinTranslatorTest {

    @Test
    void aWordBeginningWithAVowelGainsYay() {
        assertEquals("appleyay ", PigLatinTranslator.translate("apple"));
    }

    @Test
    void aWordBeginningWithOneConsonantMovesThatLetterToTheEnd() {
        assertEquals("atcay ", PigLatinTranslator.translate("cat"));
    }

    @Test
    void aWordBeginningWithABlendMovesBothLettersToTheEnd() {
        assertEquals("airchay ", PigLatinTranslator.translate("chair"));
    }

    @Test
    void aSentenceIsTranslatedWordByWord() {
        assertEquals("ethay atcay ", PigLatinTranslator.translate("the cat"));
    }

    @Test
    void translationIsCaseInsensitive() {
        assertEquals("atcay ", PigLatinTranslator.translate("CAT"));
    }

    @Test
    void anEmptySentenceTranslatesToNothing() {
        assertEquals("", PigLatinTranslator.translate(""));
    }
}
