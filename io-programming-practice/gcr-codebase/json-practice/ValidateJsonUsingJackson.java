import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonUsingJackson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\"name\":\"Shyam\",\"age\":21}"; // change to invalid to test

        try {
            mapper.readTree(json);
            System.out.println("Valid JSON ✅");
        } catch (Exception e) {
            System.out.println("Invalid JSON ❌");
        }
    }
}
