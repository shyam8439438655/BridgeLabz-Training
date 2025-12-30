import java.util.Scanner;

class FactorUtility {

    //  Method to find factors and return them as an array
    public static int[] getFactors(int n) {
        int count = 0;

        // First loop → count the factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        // Create array of exact size
        int[] factors = new int[count];
        int index = 0;

        // Second loop → store the factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    //  Find greatest factor from factors array
    public static int greatestFactor(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    //  Find sum of factors
    public static int sumOfFactors(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    //  Find product of factors
    public static int productOfFactors(int[] arr) {
        int product = 1;
        for (int num : arr) {
            product *= num;
        }
        return product;
    }

    //  Product of cube of factors → use Math.pow()
    public static double productOfCubeOfFactors(int[] arr) {
        double product = 1;

        for (int num : arr) {
            product *= Math.pow(num, 3);  // cube of factor
        }

        return product;
    }
}

public class FindFactors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Get factors array
        int[] factors = FactorUtility.getFactors(num);

        System.out.println("\nFactors:");
        for (int f : factors) {
            System.out.print(f + " ");
        }

        System.out.println("\n\n----- RESULTS -----");

        System.out.println("Greatest Factor: " + FactorUtility.greatestFactor(factors));

        System.out.println("Sum of Factors: " + FactorUtility.sumOfFactors(factors));

        System.out.println("Product of Factors: " + FactorUtility.productOfFactors(factors));

        System.out.println("Product of Cube of Factors: " + FactorUtility.productOfCubeOfFactors(factors));
        sc.close();
    }
}
