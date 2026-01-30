import java.util.*;

public class Main {

    // check vowel (works for both upper/lower)
    static boolean isVowel(char ch) {
        ch = Character.toUpperCase(ch);
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    // invalid if it contains more than one word (space/tab etc.)
    static boolean isInvalidWord(String s) {
        if (s == null) return true;
        s = s.trim();
        return s.isEmpty() || s.split("\\s+").length != 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String w1 = sc.nextLine();

        if (isInvalidWord(w1)) {
            System.out.println(w1 + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String w2 = sc.nextLine();

        if (isInvalidWord(w2)) {
            System.out.println(w2 + " is an invalid word");
            return;
        }

        String first = w1.trim();
        String second = w2.trim();

        //  case-insensitive reverse check
        String revFirst = new StringBuilder(first).reverse().toString();
        if (revFirst.equalsIgnoreCase(second)) {
            // Step 1-4: reverse first, lowercase, replace vowels with '@'
            String lower = revFirst.toLowerCase();
            StringBuilder out = new StringBuilder();

            for (int i = 0; i < lower.length(); i++) {
                char ch = lower.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    out.append('@');
                } else {
                    out.append(ch);
                }
            }

            System.out.println(out.toString());
            return;
        }

        // Not reversed
        String combined = (first + second).toUpperCase();

        int vowels = 0, consonants = 0;

        for (int i = 0; i < combined.length(); i++) {
            char ch = combined.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                if (isVowel(ch)) vowels++;
                else consonants++;
            }
        }

        if (vowels == consonants) {
            System.out.println("Vowels and consonants are equal");
            return;
        }

        // print first 2 unique vowels or consonants (based on counts)
        StringBuilder ans = new StringBuilder();
        Set<Character> used = new HashSet<>();

        boolean wantVowels = vowels > consonants;

        for (int i = 0; i < combined.length() && ans.length() < 2; i++) {
            char ch = combined.charAt(i);
            if (ch < 'A' || ch > 'Z') continue;

            boolean v = isVowel(ch);

            if (wantVowels && v) {
                if (!used.contains(ch)) {
                    used.add(ch);
                    ans.append(ch);
                }
            } else if (!wantVowels && !v) {
                if (!used.contains(ch)) {
                    used.add(ch);
                    ans.append(ch);
                }
            }
        }

        System.out.println(ans.toString());
    }
}
