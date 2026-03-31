import java.lang.annotation.*;
import java.lang.reflect.*;

public class AnnotationsRuntime {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Author {
        String name();
    }

    @Author(name = "Shyam Parashar")
    static class MyService {
        // any class
    }

    public static void main(String[] args) {

        Class<?> clazz = MyService.class;

        if (clazz.isAnnotationPresent(Author.class)) {
            Author a = clazz.getAnnotation(Author.class);
            System.out.println("Author found: " + a.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
