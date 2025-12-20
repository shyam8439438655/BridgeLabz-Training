import java.util.Scanner;
public class BmiFitnees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();

        // Calculate BMI
        double bmi = weight / (height * height);

        System.out.printf("Your BMI is: %.2f%n", bmi);

        // Determine fitness category using if-else
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } 
        else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Category: Normal");
        } 
        else {
            System.out.println("Category: Overweight");
        }

        scanner.close();
    }
}
