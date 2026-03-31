import java.util.Scanner;
public class Reverse {
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
        System.out.println("Reversed number digits:");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
        scanner.close();
    }
}
