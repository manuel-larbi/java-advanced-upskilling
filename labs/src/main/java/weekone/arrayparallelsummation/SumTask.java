package weekone.arrayparallelsummation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class SumTask extends RecursiveTask<Long> {
    private final int[] arr;
    private static final int THRESHOLD = 1000;
    private static final Logger logger = Logger.getAnonymousLogger();

    public SumTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Long compute() {
        if (arr.length > THRESHOLD) {
            long sum = invokeAll(createSubTasks()).stream().mapToLong(ForkJoinTask::join).sum();
            logger.info(sum + " was processed by " + ForkJoinTask.getPool());
            return sum;
        }
        else
            return processing();
    }

    private List<SumTask> createSubTasks() {
        List<SumTask> tasks = new ArrayList<>();

        // split arrays into two
        int[] partOne = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] partTwo = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        tasks.add(new SumTask(partOne));
        tasks.add(new SumTask(partTwo));

        return tasks;
    }

    private Long processing() {
        long sum = Arrays.stream(arr).mapToLong(a -> a).sum();
        logger.info(sum + " was processed by " + Thread.currentThread().getName());
        return sum;
    }
}
