import java.util.Scanner;

public class WordsWithLength2D {

    // Method to find length of a string without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // throws exception when index exceeds
                count++;
            }
        } catch (Exception e) {
            // End of string reached
        }
        return count;
    }

    // Method to split text into words manually using charAt()
    public static String[] manualSplit(String text) {
        int len = getLength(text);
        int wordCount = 1; // at least one word

        // Count words
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int start = 0, index = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }
        // Last word
        words[index] = text.substring(start, len);

        return words;
    }

    // Method to create 2D array with word and its length
    public static String[][] wordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i]; // word
            result[i][1] = String.valueOf(getLength(words[i])); // length as String
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Split words manually
        String[] words = manualSplit(input);

        // Create 2D array with word and length
        String[][] table = wordsWithLength(words);

        // Display result in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("-----------------");
        for (int i = 0; i < table.length; i++) {
            // Convert length back to integer before display
            int lengthValue = Integer.parseInt(table[i][1]);
            System.out.println(table[i][0] + "\t" + lengthValue);
        }

        scanner.close();
    }
}