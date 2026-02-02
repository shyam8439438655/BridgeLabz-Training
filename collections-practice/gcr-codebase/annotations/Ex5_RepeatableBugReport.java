import java.lang.annotation.*;
import java.lang.reflect.*;

public class Ex5_RepeatableBugReport {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Repeatable(BugReports.class)
    @interface BugReport {
        String description();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface BugReports {
        BugReport[] value();
    }

    static class Service {

        @BugReport(description = "NullPointerException on empty input")
        @BugReport(description = "Slow performance on large data")
        public void process() {
            System.out.println("Processing...");
        }
    }

    public static void main(String[] args) throws Exception {
        Method m = Service.class.getDeclaredMethod("process");

        BugReport[] reports = m.getAnnotationsByType(BugReport.class);
        System.out.println("Bug reports for method: " + m.getName());
        for (BugReport r : reports) {
            System.out.println("- " + r.description());
        }

        new Service().process();
    }
}
