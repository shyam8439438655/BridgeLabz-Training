import java.io.*;
import java.util.*;

class WordCount {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
        String word = sc.nextLine();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        int count = 0;

        while ((line = bufferedReader.readLine()) != null) {
            for (String w : line.split(" ")) {
                if (w.equals(word)) count++;
            }
        }
        System.out.println(count);
        bufferedReader.close();
    }
}
