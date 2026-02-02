import java.lang.annotation.*;
import java.lang.reflect.*;

public class Ann5_RoleAllowed {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface RoleAllowed {
        String value(); // like ADMIN
    }

    static class SecurityContext {
        static String currentRole = "USER"; // change to ADMIN to allow
    }

    @RoleAllowed("ADMIN")
    static class AdminPanel {
        public void deleteUser() {
            System.out.println("User deleted!");
        }
    }

    static void runIfAllowed(Object obj, String methodName) throws Exception {
        Class<?> c = obj.getClass();

        RoleAllowed ra = c.getAnnotation(RoleAllowed.class);
        if (ra != null) {
            if (!SecurityContext.currentRole.equals(ra.value())) {
                System.out.println("Access Denied! Need role: " + ra.value());
                return;
            }
        }

        Method m = c.getDeclaredMethod(methodName);
        m.invoke(obj);
    }

    public static void main(String[] args) throws Exception {
        AdminPanel panel = new AdminPanel();

        System.out.println("Current Role: " + SecurityContext.currentRole);
        runIfAllowed(panel, "deleteUser");

        SecurityContext.currentRole = "ADMIN";
        System.out.println("Current Role: " + SecurityContext.currentRole);
        runIfAllowed(panel, "deleteUser");
    }
}
