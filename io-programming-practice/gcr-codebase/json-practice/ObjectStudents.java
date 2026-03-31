import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ObjectStudents {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Shyam");
        student.put("age", 21);

        ArrayNode subjects = mapper.createArrayNode();
        subjects.add("Java");
        subjects.add("DSA");
        subjects.add("OOP");

        student.set("subjects", subjects);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student));
    }
}
