public class RandomNumbersProgram {

    // Method to generate array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 9000) + 1000; // generates 1000–9999
        }

        return arr;
    }

    // Method to find average, minimum and maximum
    public static double[] findAverageMinMax(int[] numbers) {

        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int num : numbers) {
            sum += num;

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = (double)sum / numbers.length;

        return new double[]{average, min, max};
    }

    public static void main(String[] args) {

        // Generate 5 random 4-digit numbers
        int[] randomNumbers = generate4DigitRandomArray(5);

        System.out.println("Generated Random Numbers:");
        for (int num : randomNumbers) {
            System.out.println(num);
        }

        // Get average, min, max
        double[] result = findAverageMinMax(randomNumbers);

        System.out.println("\nAverage Value: " + result[0]);
        System.out.println("Minimum Value: " + result[1]);
        System.out.println("Maximum Value: " + result[2]);
    }
}
