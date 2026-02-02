import java.lang.annotation.*;
import java.lang.reflect.*;

public class Ann6_JsonFieldSerialization {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface JsonField {
        String name();
    }

    static class User {
        @JsonField(name = "user_name")
        private String username;

        @JsonField(name = "user_email")
        private String email;

        private int age; // not annotated -> will not be included

        User(String username, String email, int age) {
            this.username = username;
            this.email = email;
            this.age = age;
        }
    }

    static String toJson(Object obj) throws Exception {
        Class<?> c = obj.getClass();
        Field[] fields = c.getDeclaredFields();

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean first = true;

        for (Field f : fields) {
            if (!f.isAnnotationPresent(JsonField.class)) continue;

            f.setAccessible(true);

            JsonField jf = f.getAnnotation(JsonField.class);
            Object val = f.get(obj);

            if (!first) sb.append(",");
            sb.append("\"").append(jf.name()).append("\":");

            if (val == null) sb.append("null");
            else sb.append("\"").append(val).append("\"");

            first = false;
        }

        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        User u = new User("Aman", "aman@gmail.com", 21);
        System.out.println(toJson(u));
    }
}
