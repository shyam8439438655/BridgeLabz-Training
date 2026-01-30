import java.util.Scanner;

public class Program {

    public static String CleanseAndInvert(String input) {

        //  null or length < 6
        if (input == null || input.length() < 6) {
            return "";
        }

        // Rule 2: only alphabets allowed (no space, digit, special char)
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isLetter(ch)) {
                return "";
            }
        }

        // Convert to lowercase
        String lower = input.toLowerCase();

        // Remove characters with even ASCII values
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if ((int) ch % 2 != 0) { // keep odd ASCII
                filtered.append(ch);
            }
        }

        // Reverse the remaining characters
        filtered.reverse();

        // Convert even positioned characters (0-based) to uppercase
        for (int i = 0; i < filtered.length(); i++) {
            if (i % 2 == 0) {
                filtered.setCharAt(i,
                        Character.toUpperCase(filtered.charAt(i)));
            }
        }

        return filtered.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word");
        String input = sc.nextLine();

        String result = CleanseAndInvert(input);

        if (result.equals("")) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }
    }
}
