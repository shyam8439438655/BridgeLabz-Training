import java.util.Scanner;
public class Frequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int tempNumber = number;
        int digitCount = 0;
        while (tempNumber != 0) {
            digitCount++;
            tempNumber /= 10;
        }
        int[] digits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        int[] frequency = new int[10];
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        System.out.println("Digit Frequencies:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " times");
            }
        }
        scanner.close();
    }
}
