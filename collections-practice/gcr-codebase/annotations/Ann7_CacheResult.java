import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class Ann7_CacheResult {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface CacheResult {}

    static class Calculator {
        private final Map<String, Object> cache = new HashMap<>();

        @CacheResult
        public long slowSquare(int n) {
            try { Thread.sleep(200); } catch (Exception ignored) {}
            return (long) n * n;
        }

        public Object callWithCache(String methodName, Class<?>[] paramTypes, Object[] args) throws Exception {
            Method m = this.getClass().getDeclaredMethod(methodName, paramTypes);

            boolean shouldCache = m.isAnnotationPresent(CacheResult.class);
            String key = methodName + "|" + Arrays.toString(args);

            if (shouldCache && cache.containsKey(key)) {
                System.out.println("[CACHE HIT] " + key);
                return cache.get(key);
            }

            long start = System.nanoTime();
            Object result = m.invoke(this, args);
            long end = System.nanoTime();

            System.out.println("[RUN] " + key + " took " + ((end - start)/1_000_000) + " ms");

            if (shouldCache) cache.put(key, result);

            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();

        System.out.println("Ans: " + c.callWithCache("slowSquare", new Class<?>[]{int.class}, new Object[]{12}));
        System.out.println("Ans: " + c.callWithCache("slowSquare", new Class<?>[]{int.class}, new Object[]{12}));
        System.out.println("Ans: " + c.callWithCache("slowSquare", new Class<?>[]{int.class}, new Object[]{9}));
    }
}
