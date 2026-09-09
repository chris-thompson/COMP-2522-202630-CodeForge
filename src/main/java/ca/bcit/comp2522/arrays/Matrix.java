package ca.bcit.comp2522.arrays;

import java.util.Arrays;

/**
 * Matrix.
 *
 * @author BCIT
 * @version 2026
 */
public final class Matrix {

    private final int[][] matrix;

    /**
     * Constructs an object of type Matrix.
     *
     * @param rows    an int
     * @param columns an int
     */
    public Matrix(final int rows, final int columns) {
        matrix = new int[rows][columns]; }

    /**
     * Returns the number of rows in this Matrix.
     *
     * @return rows as an int
     */
    public int getRows() {
        return matrix.length;
    }

    /**
     * Returns the number of columns in this Matrix.
     *
     * @return columns as an int
     */
    public int getColumns() {
        return matrix[0].length;
    }

    /**
     * Returns the value stored at the specified row and column.
     *
     * @param row    an int
     * @param column an int
     * @return value at that location in this Matrix.
     */
    public int getValue(final int row, final int column) {
        return matrix[row][column];
    }

    /**
     * Puts the specified value in the specified location.
     *
     * @param value  an int
     * @param row    an int
     * @param column an int
     */
    public void setValue(final int value, final int row, final int column) {
        matrix[row][column] = value;
    }

    /**
     * Returns a new matrix which is the sum of this matrix and the matrix
     * passed as a parameter. If the matrix passed as a parameter is the wrong
     * size, this method throws an IllegalArgumentException.
     *
     * @param otherMatrix a Matrix, possibly the wrong size
     * @return sumMatrix a new Matrix
     * @throws IllegalArgumentException if the matrix passed as a parameter is
     *                                  the wrong size
     */
    public Matrix add(final Matrix otherMatrix) {
        if (this.getRows() != otherMatrix.getRows()
                || this.getColumns() != otherMatrix.getColumns()) {
            throw new IllegalArgumentException("Wrong size. Cannot be added");
        } else {
            Matrix sumMatrix = new Matrix(this.getRows(), this.getColumns());
            for (int row = 0; row < this.getRows(); ++row) {
                for (int column = 0; column < this.getColumns(); ++column) {
                    int sum = this.getValue(row, column)
                            + otherMatrix.getValue(row, column);
                    sumMatrix.setValue(sum, row, column);
                }
            }
            return sumMatrix;
        }
    }

    /**
     * Returns a String representation of this Matrix.
     *
     * @return description
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder thisMatrix = new StringBuilder();
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; ++j) {
                thisMatrix.append(ints[j]).append(" ");
            }
            thisMatrix.append("\n");
        }
        return thisMatrix.toString();
    }

    /**
     * Compares this Matrix with another object for equality.
     *
     * This implementation compares the fields declared in Matrix and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Matrix
     * @return true if object is equal to this Matrix
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Matrix matrix1 = (Matrix) object;

        return Arrays.deepEquals(matrix, matrix1.matrix);
    }

    /**
     * Returns a hash code for this Matrix.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Matrix
     */
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }
}
