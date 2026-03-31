import java.io.*;
import java.util.*;

public class CountWords {
    public static void main(String[] args) {
        String file = "text.txt";
        HashMap<String, Integer> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " "); // remove punctuation
                String[] words = line.split("\\s+");

                for (String w : words) {
                    if (w.length() == 0) continue;
                    map.put(w, map.getOrDefault(w, 0) + 1);
                }
            }
            br.close();

            // sort by frequency (high -> low)
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

            System.out.println("Top 5 words:");
            for (int i = 0; i < 5 && i < list.size(); i++) {
                System.out.println(list.get(i).getKey() + " = " + list.get(i).getValue());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
