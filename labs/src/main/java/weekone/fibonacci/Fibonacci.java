package weekone.fibonacci;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class Fibonacci extends RecursiveTask<Integer> {
    private final int n;
    private static final int THRESHOLD = 1;
    private static final Logger logger = Logger.getAnonymousLogger();

    Fibonacci(int n) {
        this.n = n;
    }
    @Override
    public Integer compute(){
        if (n <= THRESHOLD)
            return n;
        else
           return processing(n);
    }

    private int processing(int v) {
        Fibonacci f1 = new Fibonacci(v-1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(v-2);
        f2.fork();

        return f1.join() + f2.join();
    }

    public void invoked(){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Fibonacci task = new Fibonacci(n);
        int result = forkJoinPool.invoke(task);
        logger.info("Fibonacci of " + n + " is: " + result);
    }
}
