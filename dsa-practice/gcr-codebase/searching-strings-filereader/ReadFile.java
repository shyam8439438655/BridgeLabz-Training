import java.io.*;
import java.util.*;

class ReadFile {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
