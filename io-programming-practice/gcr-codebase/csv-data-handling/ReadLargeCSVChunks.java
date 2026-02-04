import java.io.*;
import java.util.*;

public class ReadLargeCSVChunks {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("bigfile.csv"));
        String header = br.readLine(); // skip header

        List<String> chunk = new ArrayList<>(100);
        String line;
        long count = 0;

        while ((line = br.readLine()) != null) {
            chunk.add(line);

            if (chunk.size() == 100) {
                // process chunk
                count += chunk.size();
                System.out.println("Processed records: " + count);
                chunk.clear();
            }
        }

        if (!chunk.isEmpty()) {
            count += chunk.size();
            System.out.println("Processed records: " + count);
        }

        br.close();
        System.out.println("Total records processed: " + count);
    }
}
