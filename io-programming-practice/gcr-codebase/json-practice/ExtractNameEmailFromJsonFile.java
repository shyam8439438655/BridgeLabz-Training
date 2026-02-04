import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExtractNameEmailFromJsonFile {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("users.json"));

        for (JsonNode node : root) {
            System.out.println("name=" + node.get("name").asText()
                    + ", email=" + node.get("email").asText());
        }
    }
}
