import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class User {
    public String name;
    public int age;
    public User() {}
    public User(String name, int age) { this.name = name; this.age = age; }
}

public class ListToJsonArray_HandsOn {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<User> users = Arrays.asList(
                new User("Aman", 22),
                new User("Neha", 28)
        );

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users));
    }
}
