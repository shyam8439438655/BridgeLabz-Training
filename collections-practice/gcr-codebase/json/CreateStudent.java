import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class CreateStudent {
    public static void main(String[] args) throws Exception {
        Map<String, Object> student = new HashMap<>();
        student.put("name", "Rahul");
        student.put("age", 22);
        student.put("subjects", Arrays.asList("Maths", "Java", "DBMS"));

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(student));
    }
}
