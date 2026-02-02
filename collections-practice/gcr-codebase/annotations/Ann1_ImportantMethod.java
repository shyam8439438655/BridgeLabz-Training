import java.lang.annotation.*;
import java.lang.reflect.*;

public class Ann1_ImportantMethod {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface ImportantMethod {
        String level() default "HIGH";
    }

    static class App {

        @ImportantMethod
        public void payment() {}

        @ImportantMethod(level = "MEDIUM")
        public void signup() {}

        public void normal() {}
    }

    public static void main(String[] args) {
        Method[] methods = App.class.getDeclaredMethods();

        System.out.println("Important methods:");
        for (Method m : methods) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println("- " + m.getName() + " (level=" + im.level() + ")");
            }
        }
    }
}
