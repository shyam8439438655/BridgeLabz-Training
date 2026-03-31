import java.util.Scanner;

public class SubStringOfString {

    // Method to create substring manually using charAt()
    static String manualSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
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

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.next();  // next() → stops at space

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        // Manual substring using charAt()
        String manual = manualSubstring(text, start, end);

        // Built-in substring()
        String builtin = text.substring(start, end);

        // Compare both substrings
        boolean areEqual = compareStrings(manual, builtin);

        // Display Results
        System.out.println("\nManual Substring: " + manual);
        System.out.println("Built-in Substring: " + builtin);
        System.out.println("Are both substrings equal? " + areEqual);

        sc.close();
    }
}
