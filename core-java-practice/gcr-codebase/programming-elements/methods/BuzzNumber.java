import java.util.Scanner;

class NumberChecker {

    // 1. Check Prime Number
    public static boolean isPrime(int num) {
        if (num <= 1) return false;

        // check divisibility
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false; // not prime
            }
        }
        return true;
    }

    // 2. Check Neon Number
    // neon number: sum of digits of (number*number) == number
    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }

        return sum == num;
    }

    // 3. Check Spy Number
    // spy: sum of digits == product of digits
    public static boolean isSpy(int num) {
        int sum = 0;
        int product = 1;
        int n = num;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }

        return sum == product;
    }

    // 4. Check Automorphic Number
    // automorphic: number^2 ends with the number
    public static boolean isAutomorphic(int num) {
        int square = num * num;
        String sNum = String.valueOf(num);
        String sSquare = String.valueOf(square);

        return sSquare.endsWith(sNum);
    }

    // 5. Check Buzz Number
    // buzz: divisible by 7 OR ends with 7
    public static boolean isBuzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }
}

public class BuzzNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Call Methods
        boolean prime = NumberChecker.isPrime(number);
        boolean neon = NumberChecker.isNeon(number);
        boolean spy = NumberChecker.isSpy(number);
        boolean auto = NumberChecker.isAutomorphic(number);
        boolean buzz = NumberChecker.isBuzz(number);

        // Display Results
        System.out.println("\n--- Results ---");
        System.out.println("Prime Number?       : " + prime);
        System.out.println("Neon Number?        : " + neon);
        System.out.println("Spy Number?         : " + spy);
        System.out.println("Automorphic Number? : " + auto);
        System.out.println("Buzz Number?        : " + buzz);
        sc.close();
    }
}
