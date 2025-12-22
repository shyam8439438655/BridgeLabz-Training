import java.util.Scanner;

public class ShortestAndLongestString {

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

        // Count spaces to know number of words
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int start = 0, index = 0;

        // Extract words using spaces
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
            result[i][1] = String.valueOf(getLength(words[i])); // length as string
        }

        return result;
    }

    // Method to find shortest and longest word lengths
    public static int[] findShortestLongest(String[][] table) {
        int shortest = Integer.parseInt(table[0][1]);
        int longest = Integer.parseInt(table[0][1]);

        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            if (length < shortest) {
                shortest = length;
            }
            if (length > longest) {
                longest = length;
            }
        }

        return new int[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Split words manually
        String[] words = manualSplit(input);

        // Create 2D array with word and length
        String[][] table = wordsWithLength(words);

        // Display result in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("-----------------");
        for (int i = 0; i < table.length; i++) {
            int lengthValue = Integer.parseInt(table[i][1]); // convert back to int
            System.out.println(table[i][0] + "\t" + lengthValue);
        }

        // Find shortest and longest word lengths
        int[] result = findShortestLongest(table);
        System.out.println("\nShortest word length: " + result[0]);
        System.out.println("Longest word length: " + result[1]);

        sc.close();
    }
}