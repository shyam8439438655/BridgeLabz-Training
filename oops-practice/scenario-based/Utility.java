public class Utility {

    // Method to calculate the factorial of a number
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to find the greatest common divisor (GCD) of two numbers
    public static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("GCD is not defined for negative numbers.");
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to find the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci is not defined for negative numbers.");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, fib = 1;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Testing factorial
        System.out.println("Factorial of 5: " + factorial(5)); // 120
        System.out.println("Factorial of 0: " + factorial(0)); // 1

        // Testing isPrime
        System.out.println("Is 7 prime? " + isPrime(7)); // true
        System.out.println("Is 10 prime? " + isPrime(10)); // false
        System.out.println("Is 1 prime? " + isPrime(1)); // false
        System.out.println("Is -3 prime? " + isPrime(-3)); // false
        // Testing gcd
        System.out.println("GCD of 48 and 18: " + gcd(48, 18)); // 6
        System.out.println("GCD of 0 and 5: " + gcd(0, 5)); // 5
        // Testing fibonacci
        System.out.println("Fibonacci of 7: " + fibonacci(7)); // 13
        System.out.println("Fibonacci of 0: " + fibonacci(0)); // 0
        System.out.println("Fibonacci of 1: " + fibonacci(1)); // 1
    }
}