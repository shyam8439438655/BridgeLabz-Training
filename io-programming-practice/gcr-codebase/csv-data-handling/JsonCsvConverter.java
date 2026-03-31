import java.util.*;

public class JsonCsvConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter JSON array of student records:");
        String json = sc.nextLine().trim();

        String csv = jsonToCsvString(json);
        System.out.println("CSV OUTPUT");
        System.out.println(csv);

        String jsonBack = csvToJsonString(csv);
        System.out.println("JSON OUTPUT");
        System.out.println(jsonBack);

        sc.close();
    }

    static String jsonToCsvString(String json) {

        StringBuilder sb = new StringBuilder();
        sb.append("id,name,age,marks\n");

        json = json.trim();
        if (json.startsWith("[")) json = json.substring(1);
        if (json.endsWith("]")) json = json.substring(0, json.length() - 1);

        String[] objects = json.split("\\},\\s*\\{");

        for (String obj : objects) {

            obj = obj.replace("{", "").replace("}", "").replace("\"", "").trim();
            String[] fields = obj.split(",");

            String id = "", name = "", age = "", marks = "";

            for (String f : fields) {
                String[] kv = f.split(":");
                String key = kv[0].trim();
                String val = kv[1].trim();

                if (key.equals("id")) id = val;
                else if (key.equals("name")) name = val;
                else if (key.equals("age")) age = val;
                else if (key.equals("marks")) marks = val;
            }

            sb.append(id).append(",").append(name).append(",").append(age).append(",").append(marks).append("\n");
        }

        return sb.toString();
    }

    // CSV string -> JSON string
    static String csvToJsonString(String csv) {

        String[] lines = csv.trim().split("\\R");
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        for (int i = 1; i < lines.length; i++) { // skip header
            String[] d = lines[i].split(",");

            sb.append("  {");
            sb.append("\"id\":").append(d[0]).append(",");
            sb.append("\"name\":\"").append(d[1]).append("\",");
            sb.append("\"age\":").append(d[2]).append(",");
            sb.append("\"marks\":").append(d[3]);
            sb.append("}");

            if (i != lines.length - 1) sb.append(",");
            sb.append("\n");
        }

        sb.append("]");
        return sb.toString();
    }
}
