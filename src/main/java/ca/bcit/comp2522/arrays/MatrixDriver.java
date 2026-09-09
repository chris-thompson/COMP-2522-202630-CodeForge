package ca.bcit.comp2522.arrays;

/**
 * MatrixDriver.
 *
 * @author BCIT
 * @version 2026
 */
public final class MatrixDriver {

    /** A 2x2 matrix, as rows of columns. */
    private static final int[][] SQUARE_VALUES = {
        {2, 3},
        {4, 5},
    };

    /** A second 2x2 matrix, so that the two can be added. */
    private static final int[][] ANOTHER_SQUARE_VALUES = {
        {1, 2},
        {3, 4},
    };

    /** A 2x3 matrix, whose shape deliberately does not match the others. */
    private static final int[][] RECTANGLE_VALUES = {
        {1, 2, 3},
        {4, 5, 6},
    };

    private MatrixDriver() {
    }

    /**
     * Builds a Matrix from a two-dimensional array of values.
     *
     * @param values the values, as an array of rows
     * @return a Matrix holding those values
     */
    private static Matrix build(final int[][] values) {

        final Matrix matrix = new Matrix(values.length, values[0].length);

        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[row].length; column++) {
                matrix.setValue(values[row][column], row, column);
            }
        }

        return matrix;
    }

    /**
     * Drives the program.
     *
     * The three matrices below are written out as two-dimensional array
     * literals rather than as a long run of setValue calls. That is not only
     * shorter: it means you can see the shape of each matrix by looking at
     * it, which is the entire reason a matrix is written as a grid.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {

        final Matrix square = build(SQUARE_VALUES);
        System.out.println(square);

        final Matrix anotherSquare = build(ANOTHER_SQUARE_VALUES);
        System.out.println(anotherSquare);

        final Matrix rectangle = build(RECTANGLE_VALUES);
        System.out.println(rectangle);

        final Matrix sumMatrix = square.add(anotherSquare);
        System.out.println(sumMatrix);

        try {
            final Matrix wontWorkMatrix = square.add(rectangle);
            System.out.println(wontWorkMatrix);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
