import java.util.*;
import java.util.stream.*;

public class TransformingNamesForDisplay {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("nicky", "roma", "alex");

        names.stream()
             .map(String::toUpperCase)
             .sorted()
             .forEach(System.out::println);
    }
}