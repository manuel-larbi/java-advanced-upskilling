package util;

import java.util.Random;

public class ArrayGenerator {
    Random random = new Random();
    int arraySize;

    public ArrayGenerator(int size) {
        this.arraySize = size;
    }

    public int[] generateRandomIntArray(){
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(10);
        }

        return array;
    }

    public int[][] generateTwoDimensionalArray(){
        int[][] array = new int[arraySize][arraySize];

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                array[i][j] = random.nextInt(10);
            }
        }

        return array;
    }

}
