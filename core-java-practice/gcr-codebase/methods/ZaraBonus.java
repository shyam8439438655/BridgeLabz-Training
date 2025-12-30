import java.util.Scanner;

class ZaraBonusUtility {

    //  Calculate bonus and new salary
    // Returns 2D array → 0: old salary, 1: bonus, 2: new salary
    public static double[][] calculateBonus(int[][] data) {
        double[][] newData = new double[data.length][3];

        for (int i = 0; i < data.length; i++) {
            int oldSalary = data[i][0];
            int years = data[i][1];
            double bonus;

            if (years > 5) {
                bonus = oldSalary * 0.05;   // 5% bonus
            } else {
                bonus = oldSalary * 0.02;   // 2% bonus
            }

            double newSalary = oldSalary + bonus;

            newData[i][0] = oldSalary;
            newData[i][1] = bonus;
            newData[i][2] = newSalary;
        }

        return newData;
    }

    //  Display table with totals
    public static void displayTable(double[][] data, int[][] originalData) {
        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;

        System.out.println("Emp\tOld Salary\tYears\tBonus\t\tNew Salary");
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d\t%d\t\t%d\t%.2f\t\t%.2f\n", 
                              i+1, (int)data[i][0], originalData[i][1], data[i][1], data[i][2]);

            totalOldSalary += data[i][0];
            totalBonus += data[i][1];
            totalNewSalary += data[i][2];
        }

        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total\t%.0f\t\t\t%.2f\t\t%.2f\n", totalOldSalary, totalBonus, totalNewSalary);
    }
}

public class ZaraBonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int employees = 10;
        int[][] salaryData = new int[employees][2]; // 0 → salary, 1 → years

        // Step 1: User input for salary and years
        for (int i = 0; i < employees; i++) {
            System.out.print("Enter salary for Employee " + (i+1) + ": ");
            salaryData[i][0] = sc.nextInt();

            System.out.print("Enter years of service for Employee " + (i+1) + ": ");
            salaryData[i][1] = sc.nextInt();
        }

        // Step 2: Calculate bonus and new salary
        double[][] newSalaryData = ZaraBonusUtility.calculateBonus(salaryData);

        // Step 3: Display table
        ZaraBonusUtility.displayTable(newSalaryData, salaryData);
        sc.close();
    }
}
