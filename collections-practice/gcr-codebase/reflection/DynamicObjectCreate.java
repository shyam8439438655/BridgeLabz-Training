import java.lang.reflect.*;

public class DynamicObjectCreate {

    static class Student {
        int id;
        String name;

        public Student() {
            this.id = 0;
            this.name = "unknown";
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "'}";
        }
    }

    public static void main(String[] args) throws Exception {

        // create without "new"
        Class<?> clazz = Student.class;

        // using no-arg constructor
        Constructor<?> c1 = clazz.getDeclaredConstructor();
        Object obj1 = c1.newInstance();
        System.out.println("Created with no-arg: " + obj1);

        // using parameterized constructor
        Constructor<?> c2 = clazz.getDeclaredConstructor(int.class, String.class);
        Object obj2 = c2.newInstance(101, "Rahul");
        System.out.println("Created with params: " + obj2);
    }
}
