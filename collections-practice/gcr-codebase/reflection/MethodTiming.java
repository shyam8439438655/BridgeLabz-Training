import java.lang.reflect.*;

public class MethodTiming {

    static class Work {
        public void fastTask() {
            // quick loop
            long s = 0;
            for (int i = 0; i < 100000; i++) s += i;
        }

        public void slowTask() throws Exception {
            Thread.sleep(200); // simulate slow work
        }
    }

    static void timeAllNoArgMethods(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Method m : clazz.getDeclaredMethods()) {
        
            if (m.getParameterCount() == 0) {
                long start = System.nanoTime();

                try {
                    m.invoke(obj);
                } catch (InvocationTargetException ex) {
                    
                    System.out.println(m.getName() + " threw: " + ex.getTargetException());
                }

                long end = System.nanoTime();
                long ms = (end - start) / 1_000_000;

                System.out.println("Method: " + m.getName() + " | Time: " + ms + " ms");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Work w = new Work();
        timeAllNoArgMethods(w);
    }
}
