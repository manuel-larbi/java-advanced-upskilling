package weekone.parallelmatrixmultiplication;

import util.ArrayGenerator;

import java.util.Arrays;

public class ParallelMatrixMultiplicationMain {
    public static void main(String[] args) throws Exception {


        ArrayGenerator generator = new ArrayGenerator(2);
        ArrayGenerator generator2 = new ArrayGenerator(2);

        int[][] dimensionalArray = generator.generateTwoDimensionalArray();
        int[][] dimensionalArray2 = generator2.generateTwoDimensionalArray();

//        ParallelMatrixMultiplication multiplication = new ParallelMatrixMultiplication(dimensionalArray, dimensionalArray2);
//        multiplication.compute();

        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};

        ParallelMatrixMultiplication multiplier = new ParallelMatrixMultiplication(matrixA, matrixB, 0, 0, matrixA.length);
        int[][] result = multiplier.compute();

        // Print the result
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("matrix A" +Arrays.deepToString(matrixA));
        System.out.println("matrix B" +Arrays.deepToString(matrixB));
    }
}
