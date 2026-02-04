import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeTwoJsonObjects {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode a = mapper.createObjectNode();
        a.put("name", "Shyam");
        a.put("age", 21);

        ObjectNode b = mapper.createObjectNode();
        b.put("email", "shyam@gmail.com");
        b.put("city", "Delhi");

        a.setAll(b);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a));
    }
}
