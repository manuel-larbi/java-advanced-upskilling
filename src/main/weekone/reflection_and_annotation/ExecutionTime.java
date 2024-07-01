package weekone.reflection_and_annotation;

import java.lang.reflect.Method;

public class ExecutionTime {
    public static void process(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                try {
                    long startTime = System.currentTimeMillis();
                    method.setAccessible(true); // In case the method is private
                    method.invoke(obj);
                    long endTime = System.currentTimeMillis();
                    System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) + " ms");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
