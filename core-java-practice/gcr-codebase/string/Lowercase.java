import java.util.Scanner;

public class Lowercase {

    // Method 1: Convert uppercase letters to lowercase manually using charAt()
    static String manualLowercase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If character is uppercase (A-Z)
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);   // Convert to lowercase using ASCII difference
            }

            result = result + ch;
        }

        return result;
    }

    // Method 2: Compare two strings using charAt()
    static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter any text: ");
        String text = input.nextLine();   // Takes complete sentence

        // Manual lowercase conversion
        String manual = manualLowercase(text);

        // Built-in lowercase conversion
        String builtin = text.toLowerCase();

        // Compare both results
        boolean result = compareStrings(manual, builtin);

        // Display results
        System.out.println("\nManual Lowercase: " + manual);
        System.out.println("Built-in Lowercase: " + builtin);
        System.out.println("Are both equal? " + result);

        input.close();
    }
}
