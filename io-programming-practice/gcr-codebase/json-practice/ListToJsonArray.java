import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Student {
    public String name;
    public int age;
    public Student() {}
    public Student(String name, int age) { this.name = name; this.age = age; }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<Student> list = new ArrayList<>();
        list.add(new Student("Aman", 22));
        list.add(new Student("Neha", 28));

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
    }
}
