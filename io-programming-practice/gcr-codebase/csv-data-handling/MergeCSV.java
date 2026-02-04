import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {

        Map<String, String[]> map = new HashMap<>();

        
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        br1.readLine();
        String line;

        while ((line = br1.readLine()) != null) {
            String[] d = line.split(",");
            map.put(d[0], d); // id -> [id,name,age]
        }
        br1.close();

        
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        br2.readLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter("merged.csv"));
        bw.write("id,name,age,marks,grade");
        bw.newLine();

        while ((line = br2.readLine()) != null) {
            String[] d2 = line.split(","); // [id,marks,grade]
            String id = d2[0];

            if (map.containsKey(id)) {
                String[] d1 = map.get(id);
                bw.write(d1[0] + "," + d1[1] + "," + d1[2] + "," + d2[1] + "," + d2[2]);
                bw.newLine();
            }
        }

        br2.close();
        bw.close();

        System.out.println("Merged file created: merged.csv");
    }
}
