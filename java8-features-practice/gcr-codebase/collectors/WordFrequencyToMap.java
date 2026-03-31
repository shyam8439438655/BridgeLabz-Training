import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyToMap {
    public static void main(String[] args) {
        String paragraph = "Hello world, hello Java! Java is fun, and Java is powerful.";

        Map<String, Integer> freq = Arrays.stream(paragraph.toLowerCase()
                        .replaceAll("[^a-z0-9\\s]", "")   
                        .split("\\s+"))                  
                        .filter(w -> !w.isBlank())
                        .collect(Collectors.toMap(
                        Function.identity(),            
                        w -> 1,                         
                        Integer::sum                    
                ));

        System.out.println(freq);
    }
}
