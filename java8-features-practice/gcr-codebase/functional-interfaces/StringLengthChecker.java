import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {

        Function<String, Integer> lengthFinder = str -> str.length();

        String message = "Functional Interface in Java";

        int length = lengthFinder.apply(message);

        if (length > 20) {
            System.out.println("Message exceeds limit");
        } else {
            System.out.println("Message within limit");
        }
    }
}
