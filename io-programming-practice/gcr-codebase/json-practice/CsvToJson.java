import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.*;
import java.io.File;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) throws Exception {
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();

        List<JsonNode> rows = csvMapper.readerFor(JsonNode.class)
                .with(schema)
                .readValues(new File("data.csv"))
                .readAll();

        ObjectMapper jsonMapper = new ObjectMapper();
        System.out.println(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rows));
    }
}
