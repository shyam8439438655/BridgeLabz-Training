import java.lang.annotation.*;
import java.lang.reflect.*;

public class Ex4_CustomTaskInfo {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface TaskInfo {
        String priority();
        String assignedTo();
    }

    static class TaskManager {

        @TaskInfo(priority = "HIGH", assignedTo = "Aman")
        public void fixLoginBug() {
            System.out.println("Fixing login bug...");
        }
    }

    public static void main(String[] args) throws Exception {

        Method m = TaskManager.class.getDeclaredMethod("fixLoginBug");

        TaskInfo info = m.getAnnotation(TaskInfo.class);
        System.out.println("Task Method: " + m.getName());
        System.out.println("Priority: " + info.priority());
        System.out.println("Assigned To: " + info.assignedTo());

        new TaskManager().fixLoginBug();
    }
}
