package weekone.reflection_and_annotation;

public class ExecutionService {
    @LogExecutionTime
    public void execute() {
        // Simulate some work with sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method execute() executed.");
    }
}
