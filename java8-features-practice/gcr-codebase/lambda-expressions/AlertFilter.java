import java.util.*;
import java.util.function.Predicate;

public class AlertFilter {
    public static void main(String[] args) {

        List<String> alerts = Arrays.asList(
           "CRITICAL",
                "NORMAL",
                "MEDICINE",
                "CRITICAL"
        );

        // user wants only CRITICAL alerts
        Predicate<String> filter =
                a -> a.equals("CRITICAL");

        for (String a : alerts) {
            if (filter.test(a)) {
                System.out.println(a);
            }
        }
    }
}
