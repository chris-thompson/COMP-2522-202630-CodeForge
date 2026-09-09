package ca.bcit.comp2522.name;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests Name.
 *
 * Read this file as well as running it. A test suite is a specification you
 * can execute: every method below states one thing that must be true about
 * Name, in a form the machine can check. When you are unsure what a class
 * promises, its tests are often a better answer than its documentation,
 * because the tests cannot quietly go out of date.
 *
 * Four conventions are in force here, and they are the same ones your labs
 * are held to:
 *
 *   1. One logical assertion per test method. When a test fails you should
 *      learn exactly one thing from it.
 *   2. Each method is named for the partition or boundary it covers, so the
 *      failure report reads like a sentence.
 *   3. Only arguments that satisfy the preconditions. There are no tests for
 *      "what happens if I pass rubbish", because Name does not promise
 *      anything about rubbish.
 *   4. A documented exception is different: if the Javadoc promises to throw,
 *      that promise is part of the contract and must be tested. See MatrixTest.
 *
 * @author BCIT
 * @version 2026
 */
class NameTest {

    private Name name;

    @BeforeEach
    void setUp() {
        name = new Name("Ada", "Byron", "Lovelace");
    }

    @Nested
    class Accessors {

        @Test
        void getFirstReturnsTheFirstName() {
            assertEquals("Ada", name.getFirst());
        }

        @Test
        void getMiddleReturnsTheMiddleName() {
            assertEquals("Byron", name.getMiddle());
        }

        @Test
        void getLastReturnsTheLastName() {
            assertEquals("Lovelace", name.getLast());
        }

        @Test
        void setFirstReplacesTheFirstName() {
            name.setFirst("Augusta");
            assertEquals("Augusta", name.getFirst());
        }
    }

    @Nested
    class DerivedValues {

        @Test
        void getLengthIsTheSumOfTheThreePartLengths() {
            assertEquals("Ada".length() + "Byron".length() + "Lovelace".length(),
                    name.getLength());
        }

        @Test
        void getInitialsIsOneUppercaseLetterFromEachPart() {
            assertEquals("ABL", name.getInitials());
        }

        @Test
        void getFormattedNamePutsTheLastNameFirst() {
            assertEquals("Lovelace, Ada Byron", name.getFormattedName());
        }
    }

    @Nested
    class GetCharacter {

        // The three partitions of the index argument are: the first character,
        // an interior character, and the boundary at which the documented
        // fallback takes over. Each gets exactly one test.

        @Test
        void indexZeroReturnsTheFirstCharacter() {
            assertEquals('A', name.getCharacter(0));
        }

        @Test
        void indexInsideTheNameReturnsThatCharacter() {
            // "AdaByronLovelace" — index 3 is the 'B' that starts the middle name.
            assertEquals('B', name.getCharacter(3));
        }

        @Test
        void indexAtTheLengthReturnsTheDocumentedFallback() {
            // The Javadoc promises '@' rather than an exception at this boundary,
            // so the boundary itself is part of the contract and is tested.
            assertEquals('@', name.getCharacter(name.getLength()));
        }
    }

    @Nested
    class Comparison {

        @Test
        void isFirstNameIsTrueForTheFirstName() {
            assertTrue(name.isFirstName("Ada"));
        }

        @Test
        void isFirstNameIsFalseForAnyOtherName() {
            assertFalse(name.isFirstName("Grace"));
        }

        @Test
        void twoNamesWithTheSamePartsAreEqual() {
            assertEquals(new Name("Ada", "Byron", "Lovelace"), name);
        }

        @Test
        void twoNamesDifferingInOnePartAreNotEqual() {
            assertNotEquals(new Name("Ada", "Byron", "King"), name);
        }

        @Test
        void equalNamesShareAHashCode() {
            // This is the equals/hashCode contract, and it is the one students
            // most often break. Two objects that are equal MUST return the
            // same hash code, or they go missing inside a HashMap or HashSet.
            assertEquals(new Name("Ada", "Byron", "Lovelace").hashCode(),
                    name.hashCode());
        }
    }
}
