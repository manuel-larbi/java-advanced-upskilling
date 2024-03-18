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

}
