package weekone.parallelmatrixmultiplication;

import java.util.concurrent.RecursiveTask;

class ParallelMatrixMultiplication extends RecursiveTask<int[][]> {
    private final int[][] matrixA;
    private final int[][] matrixB;
    private final int startRowA;
    private final int startColB;
    private final int size;

    public ParallelMatrixMultiplication(int[][] matrixA, int[][] matrixB, int startRowA, int startColB, int size) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.startRowA = startRowA;
        this.startColB = startColB;
        this.size = size;
    }

    @Override
    protected int[][] compute() {
        if (size <= 2) { // Base case: When size is small, do regular multiplication
            return regularMatrixMultiplication();
        }

        int newSize = size / 2;

        // Divide matrixA into quadrants
        ParallelMatrixMultiplication a11b11 = new ParallelMatrixMultiplication(matrixA, matrixB, startRowA, startColB, newSize);
        ParallelMatrixMultiplication a12b21 = new ParallelMatrixMultiplication(matrixA, matrixB, startRowA, startColB + newSize, newSize);
        ParallelMatrixMultiplication a11b12 = new ParallelMatrixMultiplication(matrixA, matrixB, startRowA, startColB, newSize);
        ParallelMatrixMultiplication a12b22 = new ParallelMatrixMultiplication(matrixA, matrixB, startRowA, startColB + newSize, newSize);

        // Fork tasks
        a11b11.fork();
        a12b21.fork();
        a11b12.fork();
        a12b22.fork();

        // Compute other quadrants directly
        int[][] a21b11 = regularMatrixMultiplication(matrixA, matrixB, startRowA + newSize, startColB, newSize);
        int[][] a22b21 = regularMatrixMultiplication(matrixA, matrixB, startRowA + newSize, startColB + newSize, newSize);
        int[][] a21b12 = regularMatrixMultiplication(matrixA, matrixB, startRowA + newSize, startColB, newSize);
        int[][] a22b22 = regularMatrixMultiplication(matrixA, matrixB, startRowA + newSize, startColB + newSize, newSize);

        // Join results
        int[][] result = new int[size][size];
        joinQuadrants(result, a11b11.join(), a12b21.join(), a21b11, a22b21, newSize, 0, 0);
        joinQuadrants(result, a11b12.join(), a12b22.join(), a21b12, a22b22, newSize, 0, newSize);

        return result;
    }

    // Regular matrix multiplication for small matrices
    private int[][] regularMatrixMultiplication() {
        return regularMatrixMultiplication(matrixA, matrixB, startRowA, startColB, size);
    }

    // Regular matrix multiplication for given sub-matrices
    private int[][] regularMatrixMultiplication(int[][] a, int[][] b, int startRowA, int startColB, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += a[startRowA + i][startColB + k] * b[startRowA + k][startColB + j];
                }
            }
        }
        return result;
    }

    // Join sub-results into the final result matrix
    private void joinQuadrants(int[][] result, int[][] a11b11, int[][] a12b21, int[][] a21b11, int[][] a22b21,
                               int size, int startRow, int startCol) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[startRow + i][startCol + j] = a11b11[i][j] + a12b21[i][j];
                result[startRow + i][startCol + j + size] = a21b11[i][j] + a22b21[i][j];
            }
        }
    }
}

