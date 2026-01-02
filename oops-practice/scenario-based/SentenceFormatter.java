import java.util.Scanner;
public class SentenceFormatter {

    // Method to format the paragraph
    public static String formatParagraph(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        //  Trim extra spaces at start and end
        text = text.trim();

        // Replace multiple spaces with single space
        text = text.replaceAll("\\s+", " ");

        // Ensure one space after punctuation (. ? !)
        text = text.replaceAll("([.?!])\\s*", "$1 ");

        // Capitalize first letter of each sentence
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : text.toCharArray()) {
            if (capitalizeNext && Character.isLetter(c)) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(c);
            }

            // After punctuation, next letter should be capitalized
            if (c == '.' || c == '?' || c == '!') {
                capitalizeNext = true;
            }
        }

        return result.toString().trim();
    }

    // Main method to test
    public static void Formatted (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = formatParagraph(input);
        System.out.println("Original: " + input);
        System.out.println("Formatted: " + output);
        scanner.close();
    }
}