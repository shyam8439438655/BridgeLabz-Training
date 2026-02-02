import java.io.*;

public class FilterStudents {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        String line;

        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            int marks = Integer.parseInt(data[2]);

            if (marks > 80) {
                System.out.println(line);
            }
        }

        br.close();
    }
}