import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class FileReadPerformance {

    // Reading file using FileReader (Character Stream)
    static void readWithFileReader(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            while ((fr.read()) != -1) {
                // just reading, do nothing
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Reading file using InputStreamReader (Byte Stream)
    static void readWithInputStreamReader(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            while ((isr.read()) != -1) {
                // just reading, do nothing
            }
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "largefile.txt";

        //  FileReader 
        long start = System.currentTimeMillis();
        readWithFileReader(filePath);
        System.out.println("FileReader Time: " + (System.currentTimeMillis() - start) + " ms");

        // InputStreamReader 
        start = System.currentTimeMillis();
        readWithInputStreamReader(filePath);
        System.out.println("InputStreamReader Time: " + (System.currentTimeMillis() - start) + " ms");
    }
}
