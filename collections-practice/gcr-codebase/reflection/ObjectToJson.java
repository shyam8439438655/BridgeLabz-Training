import java.lang.reflect.*;

public class ObjectToJson {

    static String toJsonLike(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);

            Object val = f.get(obj);

            sb.append("\"").append(f.getName()).append("\":");
            if (val == null) {
                sb.append("null");
            } else if (val instanceof Number || val instanceof Boolean) {
                sb.append(val);
            } else {
                sb.append("\"").append(val).append("\"");
            }

            if (i != fields.length - 1) sb.append(",");
        }

        sb.append("}");
        return sb.toString();
    }

    static class Employee {
        private int id;
        private String name;
        private String email;
        private double salary;

        Employee(int id, String name, String email, double salary) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.salary = salary;
        }
    }

    public static void main(String[] args) throws Exception {
        Employee e = new Employee(1, "Neha", "neha@company.com", 75000);
        System.out.println(toJsonLike(e));
    }
}
