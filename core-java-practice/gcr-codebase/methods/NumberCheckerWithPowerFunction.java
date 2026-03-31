import java.util.Arrays;
public class NumberCheckerWithPowerFunction {
    public static void main(String[] args) {
        int number = 12345;

        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        int[] digitsArray = storeDigitsInArray(number);
        System.out.println("Digits array: " + Arrays.toString(digitsArray));

        int sumOfDigits = sumOfDigits(digitsArray);
        System.out.println("Sum of digits: " + sumOfDigits);

        int sumOfSquares = sumOfSquaresOfDigits(digitsArray);
        System.out.println("Sum of squares of digits: " + sumOfSquares);

        boolean isHarshad = isHarshadNumber(number, sumOfDigits);
        System.out.println("Is Harshad number: " + isHarshad);

        int[][] frequencyArray = digitFrequency(number);
        System.out.println("Digit frequency:");
        for (int[] row : frequencyArray) {
            System.out.println("Digit: " + row[0] + ", Frequency: " + row[1]);
        }
    }

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] storeDigitsInArray(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int sumOfDigits) {
        return number % sumOfDigits == 0;
    }

    public static int[][] digitFrequency(int number) {
        int[][] frequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i; // Digit
            frequency[i][1] = 0; // Frequency
        }
        while (number > 0) {
            int digit = number % 10;
            frequency[digit][1]++;
            number /= 10;
        }
        return frequency;
    }
}
