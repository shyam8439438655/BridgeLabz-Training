import java.util.Scanner;

public class ParagraphAnalyzer {

    // Method to count words
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+"); // split by spaces
        return words.length;
    }

    // Method to find longest word
    public static String findLongestWord(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }
        String[] words = text.trim().split("\\s+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    // Method to replace word (case-insensitive)
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }
        // (?i) makes it case-insensitive
        return text.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input paragraph
        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();

        // Count words
        int wordCount = countWords(paragraph);
        System.out.println("Word Count: " + wordCount);

        // Find longest word
        String longestWord = findLongestWord(paragraph);
        System.out.println("Longest Word: " + longestWord);

        // Replace word
        System.out.println("Enter word to replace:");
        String oldWord = sc.nextLine();
        System.out.println("Enter new word:");
        String newWord = sc.nextLine();

        String replacedParagraph = replaceWord(paragraph, oldWord, newWord);
        System.out.println("Updated Paragraph: " + replacedParagraph);

        sc.close();
    }
}