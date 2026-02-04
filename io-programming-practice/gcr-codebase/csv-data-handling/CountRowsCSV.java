import java.io.BufferedReader;
import java.io.FileReader;

public class CountRowsCSV {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        String line;
        int count = 0;

        // skip header
        br.readLine();

        while ((line = br.readLine()) != null) {
            count++;
        }

        br.close();
        System.out.println("Total Records: " + count);
    }
}
