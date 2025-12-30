import java.util.Scanner;
public class BmiCalsiTwoD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of persons
        System.out.print("Enter number of persons: ");
        int n = scanner.nextInt();
        // 2D array: [height, weight, BMI]
        double[][] personData = new double[n][3];
        String[] status = new String[n];

        // Input height and weight
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1));

            // weight
            double w;
            do {
                System.out.print("Enter weight (kg): ");
                w = scanner.nextDouble();
            } while (w <= 0);

            // height
            double h;
            do {
                System.out.print("Enter height (m): ");
                h = scanner.nextDouble();
            } while (h <= 0);

            personData[i][0] = h;
            personData[i][1] = w;

            // BMI
            personData[i][2] = w / (h * h);

            // Status
            double bmi = personData[i][2];
            if (bmi <= 18.4) status[i] = "Underweight";
            else if (bmi <= 24.9) status[i] = "Normal";
            else if (bmi <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        // Display results
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) +
                ": Height=" + personData[i][0] +
                " m, Weight=" + personData[i][1] +
                " kg, BMI=" + String.format("%.2f", personData[i][2]) +
                ", Status=" + status[i]);
        }

        scanner.close();
    }
}
