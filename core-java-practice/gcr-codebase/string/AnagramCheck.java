import java.util.Scanner;

public class AnagramCheck {

    // Method to check if two texts are anagrams
    public static boolean isAnagram(String text1, String text2) {
        // Step 1: Check length
        if (text1.length() != text2.length()) return false;

        // Step 2: Frequency arrays for ASCII characters
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // Step 3: Count frequency of each character
        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // Step 4: Compare frequencies
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user inputs
        System.out.print("Enter first text: ");
        String text1 = input.nextLine();

        System.out.print("Enter second text: ");
        String text2 = input.nextLine();

        // Check anagram
        boolean result = isAnagram(text1, text2);

        // Display result
        System.out.println(result ? "The texts are Anagrams" : "The texts are NOT Anagrams");

        input.close();
    }
}