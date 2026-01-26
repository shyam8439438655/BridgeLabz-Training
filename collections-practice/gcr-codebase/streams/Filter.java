import java.io.*;

public class Filter {
    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            // Reader and Writer with buffering
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            int ch;
            while ((ch = br.read()) != -1) {
                // convert each character to lowercase
                bw.write(Character.toLowerCase((char) ch));
            }

            br.close();
            bw.close();

            System.out.println("File converted successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
