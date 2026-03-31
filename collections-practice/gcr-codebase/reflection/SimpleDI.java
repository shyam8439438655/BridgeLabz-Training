import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class SimpleDI {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Inject {}

    // dependency
    static class EmailService {
        public void send(String to) {
            System.out.println("Email sent to: " + to);
        }
    }

    // class needing dependency
    static class UserController {
        @Inject
        private EmailService emailService;

        public void registerUser(String email) {
            System.out.println("User registered: " + email);
            emailService.send(email);
        }
    }

    // mini DI container
    static class SimpleContainer {
        private final Map<Class<?>, Object> singletons = new HashMap<>();

        public <T> T getBean(Class<T> clazz) throws Exception {
            // create or return singleton
            Object existing = singletons.get(clazz);
            if (existing != null) return clazz.cast(existing);

            T obj = clazz.getDeclaredConstructor().newInstance();
            singletons.put(clazz, obj);

            injectFields(obj);
            return obj;
        }

        private void injectFields(Object obj) throws Exception {
            Class<?> clazz = obj.getClass();

            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Inject.class)) {
                    f.setAccessible(true);

                    Class<?> depType = f.getType();
                    Object dep = getBean(depType);

                    f.set(obj, dep);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SimpleContainer container = new SimpleContainer();
        UserController controller = container.getBean(UserController.class);

        controller.registerUser("aman@gmail.com");
    }
}
