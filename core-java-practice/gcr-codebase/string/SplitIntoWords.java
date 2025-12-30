import java.util.Scanner;

public class SplitIntoWords {

    // Method to find length without using length()
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

    // Method to split text into words manually
    public static String[] manualSplit(String text) {
        int len = getLength(text);

        // Step 1: Count words and store space indexes
        int wordCount = 1; // at least one word
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        // Step 2: Extract words using indexes
        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < spaceIndexes.length; i++) {
            words[i] = text.substring(start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }
        // Last word
        words[wordCount - 1] = text.substring(start, len);

        return words;
    }

    // Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Manual split
        String[] manualResult = manualSplit(input);

        // Built-in split()
        String[] builtInResult = input.split(" ");

        // Compare arrays
        boolean isSame = compareArrays(manualResult, builtInResult);

        // Display results
        System.out.println("\nManual Split Result:");
        for (String word : manualResult) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in split() Result:");
        for (String word : builtInResult) {
            System.out.println(word);
        }

        System.out.println("\nComparison Result: " + (isSame ? "Both arrays are identical" : "Arrays differ"));

        scanner.close();
    }
}