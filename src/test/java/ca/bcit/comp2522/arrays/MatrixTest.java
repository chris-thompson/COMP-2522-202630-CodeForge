package ca.bcit.comp2522.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Matrix, including the exception its Javadoc promises.
 *
 * Note the last test in this file. Matrix.add documents that it throws
 * IllegalArgumentException when the two matrices are different shapes. That is
 * NOT a negative test: a documented exception is part of the contract, exactly
 * as much as the return value is, so it must be covered. The distinction the
 * course draws is between behaviour a method promises (test it) and behaviour
 * it says nothing about (do not test it).
 *
 * Note also how the exception is tested: assertThrows captures it so that its
 * message can be checked, and the message check is a single assertTrue. That
 * is the one place two assertions in one test method are permitted, because
 * assertThrows is capturing a value rather than making a second claim.
 *
 * @author BCIT
 * @version 2026
 */
class MatrixTest {

    private Matrix square;

    @BeforeEach
    void setUp() {
        square = new Matrix(2, 2);
        square.setValue(2, 0, 0);
        square.setValue(3, 0, 1);
        square.setValue(4, 1, 0);
        square.setValue(5, 1, 1);
    }

    @Test
    void getRowsReturnsTheRowCount() {
        assertEquals(2, square.getRows());
    }

    @Test
    void getColumnsReturnsTheColumnCount() {
        assertEquals(2, square.getColumns());
    }

    @Test
    void getValueReturnsWhatSetValuePutThere() {
        assertEquals(3, square.getValue(0, 1));
    }

    @Test
    void aNewMatrixStartsFilledWithZero() {
        assertEquals(0, new Matrix(2, 2).getValue(0, 0));
    }

    @Test
    void addingTwoMatricesAddsThemElementwise() {
        final Matrix other = new Matrix(2, 2);
        other.setValue(1, 0, 0);
        other.setValue(2, 0, 1);
        other.setValue(3, 1, 0);
        other.setValue(4, 1, 1);

        assertEquals(9, square.add(other).getValue(1, 1));
    }

    @Test
    void addingTwoMatricesLeavesBothOperandsUnchanged() {
        final Matrix other = new Matrix(2, 2);
        square.add(other);
        assertEquals(2, square.getValue(0, 0));
    }

    @Test
    void addingMatricesOfDifferentShapesThrowsAsDocumented() {
        final Matrix rectangle = new Matrix(2, 3);

        final IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class,
                    () -> square.add(rectangle));

        assertTrue(thrown.getMessage().contains("Wrong size"));
    }
}
