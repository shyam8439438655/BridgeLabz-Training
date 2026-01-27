import java.io.*;

class TryWithResource {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
            String line = br.readLine();
            System.out.println(line);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
