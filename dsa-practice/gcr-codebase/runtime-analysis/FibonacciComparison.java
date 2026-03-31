public class FibonacciComparison {

    // Recursive Fibonacci (O(2^N))
    static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30; 

        //  Recursive 
        long start = System.currentTimeMillis();
        int resultRecursive = fibonacciRecursive(n);
        long end = System.currentTimeMillis();
        System.out.println("Recursive Fibonacci Result: " + resultRecursive);
        System.out.println("Recursive Fibonacci Time: " + (end - start) + " ms");

        //  Iterative 
        start = System.currentTimeMillis();
        int resultIterative = fibonacciIterative(n);
        end = System.currentTimeMillis();
        System.out.println("Iterative Fibonacci Result: " + resultIterative);
        System.out.println("Iterative Fibonacci Time: " + (end - start) + " ms");
    }
}
