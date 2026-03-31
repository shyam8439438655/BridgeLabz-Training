import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {
    public static void main(String[] args) throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        String json = "{\"name\":\"Shyam\",\"age\":21}";
        Object obj = jsonMapper.readValue(json, Object.class);

        System.out.println(xmlMapper.writeValueAsString(obj));
    }
}
