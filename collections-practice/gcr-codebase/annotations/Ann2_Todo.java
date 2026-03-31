import java.lang.annotation.*;
import java.lang.reflect.*;

public class Ann2_Todo {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Todo {
        String task();
        String assignedTo();
        String priority() default "MEDIUM";
    }

    static class Project {

        @Todo(task = "Add forgot password", assignedTo = "Neha", priority = "HIGH")
        public void authModule() {}

        @Todo(task = "Improve UI spacing", assignedTo = "Rahul")
        public void uiModule() {}
    }

    public static void main(String[] args) {
        System.out.println("Pending TODOs:");

        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println("- Method: " + m.getName());
                System.out.println("  Task: " + t.task());
                System.out.println("  Assigned: " + t.assignedTo());
                System.out.println("  Priority: " + t.priority());
            }
        }
    }
}
