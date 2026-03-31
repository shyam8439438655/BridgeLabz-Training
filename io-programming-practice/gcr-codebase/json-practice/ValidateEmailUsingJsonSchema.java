import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;

import java.io.File;
import java.util.Set;

public class ValidateEmailUsingJsonSchema {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode schemaNode = mapper.readTree(new File("schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);
        JsonSchema schema = factory.getSchema(schemaNode);

        JsonNode data = mapper.readTree("{\"email\":\"test@gmail.com\"}");

        Set<ValidationMessage> errors = schema.validate(data);

        if (errors.isEmpty()) System.out.println("Valid Email ✅");
        else System.out.println("Invalid ❌ " + errors);
    }
}
