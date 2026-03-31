import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class JsonReportFromDatabaseRecords {
    public static void main(String[] args) throws Exception {
        List<Map<String, Object>> report = new ArrayList<>();

        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 101);
        row1.put("name", "Aman");
        row1.put("email", "aman@gmail.com");

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 102);
        row2.put("name", "Neha");
        row2.put("email", "neha@gmail.com");

        report.add(row1);
        report.add(row2);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(report));
    }
}
