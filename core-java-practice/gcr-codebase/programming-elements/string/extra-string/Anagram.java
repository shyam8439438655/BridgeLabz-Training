import java.util.Scanner;

public class Anagram {

    // Method to check if two strings are anagrams
    public static boolean isAnagram(String str1, String str2) {
        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths are different, not an anagram
        if (str1.length() != str2.length()) {
            return false;
        }

        // Count frequency of characters
        int[] freq = new int[256]; // ASCII size

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i)]++;
            freq[str2.charAt(i)]--;
        }

        // Check if all counts are zero
        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two strings
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        // Check anagram
        if (isAnagram(str1, str2)) {
            System.out.println("The strings are Anagrams.");
        } else {
            System.out.println("The strings are NOT Anagrams.");
        }

        sc.close();
    }
}