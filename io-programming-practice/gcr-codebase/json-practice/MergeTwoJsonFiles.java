import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class MergeTwoJsonFiles {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode a = (ObjectNode) mapper.readTree(new File("file1.json"));
        ObjectNode b = (ObjectNode) mapper.readTree(new File("file2.json"));

        a.setAll(b);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a));
    }
}
