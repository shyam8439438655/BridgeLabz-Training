public class ReverseString {
    public static void main(String[] args) {
        String input = "Hello, World!";
        String reversed = reverse(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }

    public static String reverse(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
}