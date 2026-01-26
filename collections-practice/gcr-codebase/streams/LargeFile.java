import java.io.*;

public class LargeFile {
    public static void main(String[] args) {
        String file = "biglog.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}
