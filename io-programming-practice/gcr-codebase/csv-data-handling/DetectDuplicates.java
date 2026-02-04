import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine(); // header

        Set<String> seen = new HashSet<>();
        Set<String> printed = new HashSet<>(); 

        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            String id = d[0];

            if (!seen.add(id)) {
                if (printed.add(id)) {
                    System.out.println("Duplicate found for ID: " + id);
                }
                System.out.println("  Duplicate Row: " + line);
            }
        }

        br.close();
    }
}
