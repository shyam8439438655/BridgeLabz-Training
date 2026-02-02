import java.lang.reflect.*;
import java.util.*;

public class ObjectMapper {
    
    static <T> T toObject(Class<T> clazz, Map<String, Object> props) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> e : props.entrySet()) {
            String fieldName = e.getKey();
            Object value = e.getValue();

            try {
                Field f = clazz.getDeclaredField(fieldName);
                f.setAccessible(true);

                // basic type handling
                Class<?> type = f.getType();
                if (value != null && !type.isAssignableFrom(value.getClass())) {
                    value = convert(type, value);
                }

                f.set(obj, value);
            } catch (NoSuchFieldException ex) {
                // ignore unknown keys
            }
        }
        return obj;
    }

    static Object convert(Class<?> type, Object value) {
        String s = String.valueOf(value);

        if (type == int.class || type == Integer.class) return Integer.parseInt(s);
        if (type == long.class || type == Long.class) return Long.parseLong(s);
        if (type == double.class || type == Double.class) return Double.parseDouble(s);
        if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(s);

        return s; // fallback
    }

    // demo model
    static class Student {
        public int id;
        private String name;
        public double marks;

        public Student() {}

        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "', marks=" + marks + "}";
        }
    }

    public static void main(String[] args) throws Exception {

        Map<String, Object> props = new HashMap<>();
        props.put("id", "101");        // string, will convert to int
        props.put("name", "Aman");
        props.put("marks", 92.5);

        Student s = toObject(Student.class, props);
        System.out.println(s);
    }
}
