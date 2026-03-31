import com.fasterxml.jackson.databind.*;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class PrintAllKeysValues {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("users.json"));

        for (JsonNode obj : root) {
            Iterator<Map.Entry<String, JsonNode>> fields = obj.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> f = fields.next();
                System.out.println(f.getKey() + " : " + f.getValue());
            }
            System.out.println("-----");
        }
    }
}
