import java.util.Scanner;

class NumberUtility {

    // Method to calculate sum of proper divisors
    public static int sumOfProperDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Check Perfect Number
    public static boolean isPerfect(int n) {
        int sum = sumOfProperDivisors(n);
        return sum == n;
    }

    // Check Abundant Number
    public static boolean isAbundant(int n) {
        int sum = sumOfProperDivisors(n);
        return sum > n;
    }

    //  Check Deficient Number
    public static boolean isDeficient(int n) {
        int sum = sumOfProperDivisors(n);
        return sum < n;
    }

    // Method to calculate factorial of digit
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    //  Check Strong Number
    public static boolean isStrong(int n) {
        int temp = n;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == n;
    }
}

public class StrongNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("----- RESULTS -----");

        System.out.println(num + " is Perfect? " + NumberUtility.isPerfect(num));
        System.out.println(num + " is Abundant? " + NumberUtility.isAbundant(num));
        System.out.println(num + " is Deficient? " + NumberUtility.isDeficient(num));
        System.out.println(num + " is Strong? " + NumberUtility.isStrong(num));
        sc.close();
    }
}
