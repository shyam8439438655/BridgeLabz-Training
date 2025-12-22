import java.util.Scanner;

public class LeadingAndTrailingSpace {

    // Method to find start and end indexes without leading/trailing spaces
    public static int[] findTrimIndexes(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Trim leading spaces
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String makeSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

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
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        // Find trim indexes
        int[] indexes = findTrimIndexes(input);

        // Handle case where string is all spaces
        String customTrimmed = "";
        if (indexes[0] <= indexes[1]) {
            customTrimmed = makeSubstring(input, indexes[0], indexes[1]);
        }

        // Get trimmed string using built-in trim()
        String builtInTrimmed = input.trim();

        // Compare both
        boolean isSame = compareStrings(customTrimmed, builtInTrimmed);

        // Display results
        System.out.println("\nOriginal String: [[" + input + "]]");
        System.out.println("Custom Trimmed String: [[" + customTrimmed + "]]");
        System.out.println("Built-in Trimmed String: [[" + builtInTrimmed + "]]");
        System.out.println("Are both same? " + isSame);

        sc.close();
    }
}