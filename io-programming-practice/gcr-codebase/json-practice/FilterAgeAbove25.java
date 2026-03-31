import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterAgeAbove25 {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("users.json"));

        for (JsonNode node : root) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node.toString());
            }
        }
    }
}
