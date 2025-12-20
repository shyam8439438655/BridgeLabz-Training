import java.util.Scanner;
public class Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int EMPLOYEE_COUNT = 10;
        double[] salaries = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonuses = new double[EMPLOYEE_COUNT];
        double[] newSalaries = new double[EMPLOYEE_COUNT];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double salary = scanner.nextDouble();
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double years = scanner.nextDouble();
            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
                continue;
            }
            salaries[i] = salary;
            yearsOfService[i] = years;
        }
         
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            double bonusRate = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusRate;
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        scanner.close();
    }
}
