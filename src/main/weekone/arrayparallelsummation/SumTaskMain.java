package weekone.arrayparallelsummation;

import util.ArrayGenerator;

public class SumTaskMain {
    public static void main(String[] args) {
        ArrayGenerator generator = new ArrayGenerator(10000);

        int[] arr = generator.generateRandomIntArray();

        new SumTask(arr).compute();
    }
}
