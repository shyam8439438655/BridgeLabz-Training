import java.util.Scanner;

public class BmiCalculator {

    // a. Method to take input and store weight, height, BMI
    public static double[][] inputData(Scanner sc) {
        double[][] data = new double[10][3]; // 10 rows, 3 columns: weight, height, BMI

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();

            // b. Calculate BMI and store in 3rd column
            double heightInMeters = data[i][1] / 100.0;
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters);
        }
        return data;
    }

    // c. Method to determine BMI status
    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            double bmi = data[i][2];

            if (bmi <= 18.4)
                status[i] = "Underweight";
            else if (bmi <= 24.9)
                status[i] = "Normal";
            else if (bmi <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }
        return status;
    }

    // Method to display result
    public static void displayResult(double[][] data, String[] status) {
        System.out.println("\nBMI Report:");
        System.out.println("Person\tWeight\tHeight\tBMI\t\tStatus");

        for (int i = 0; i < 10; i++) {
            System.out.printf("P%d\t%.1f\t%.1f\t%.2f\t%s\n",
                (i + 1), data[i][0], data[i][1], data[i][2], status[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] bmiData = inputData(sc);
        String[] bmiStatus = getBMIStatus(bmiData);
        displayResult(bmiData, bmiStatus);

        sc.close();
    }
}