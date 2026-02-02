import java.lang.reflect.*;
import java.util.*;

public class ClassInfo {

    // Some demo classes you can inspect
    static class DemoStudent {
        public int id;
        private String name;

        public DemoStudent() {}
        public DemoStudent(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void sayHi() {}
        private void secret() {}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter class name (example: java.util.ArrayList or Basic1_ClassInfo$DemoStudent):");
        String className = sc.nextLine().trim();

        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("\n=== CLASS ===");
            System.out.println("Name: " + clazz.getName());
            System.out.println("Simple Name: " + clazz.getSimpleName());
            System.out.println("Package: " + (clazz.getPackage() == null ? "(default)" : clazz.getPackage().getName()));

            System.out.println("\n=== FIELDS (declared) ===");
            for (Field f : clazz.getDeclaredFields()) {
                System.out.println(modifiers(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName());
            }

            System.out.println("\n=== CONSTRUCTORS (declared) ===");
            for (Constructor<?> c : clazz.getDeclaredConstructors()) {
                System.out.println(modifiers(c.getModifiers()) + " " + c.getName() + "(" + params(c.getParameterTypes()) + ")");
            }

            System.out.println("\n=== METHODS (declared) ===");
            for (Method m : clazz.getDeclaredMethods()) {
                System.out.println(modifiers(m.getModifiers()) + " " + m.getReturnType().getSimpleName() + " " + m.getName()
                        + "(" + params(m.getParameterTypes()) + ")");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found. Check name/spelling.");
        }

        sc.close();
    }

    static String params(Class<?>[] arr) {
        if (arr.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i].getSimpleName());
            if (i != arr.length - 1) sb.append(", ");
        }
        return sb.toString();
    }

    static String modifiers(int mod) {
        String s = Modifier.toString(mod);
        return s.isEmpty() ? "(default)" : s;
    }
}
