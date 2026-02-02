import java.lang.annotation.*;
import java.lang.reflect.*;

public class Ann3_LogExecutionTime {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface LogExecutionTime {}

    static class Worker {

        @LogExecutionTime
        public void fast() {
            long s = 0;
            for (int i = 0; i < 200000; i++) s += i;
        }

        @LogExecutionTime
        public void slow() throws Exception {
            Thread.sleep(200);
        }

        public void normal() {}
    }

    static void runAndLogTime(Object obj) throws Exception {
        Class<?> c = obj.getClass();

        for (Method m : c.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();
                try {
                    m.invoke(obj);
                } catch (InvocationTargetException ex) {
                    throw new RuntimeException(ex.getTargetException());
                }
                long end = System.nanoTime();

                long ms = (end - start) / 1_000_000;
                System.out.println(m.getName() + " took " + ms + " ms");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        runAndLogTime(new Worker());
    }
}
