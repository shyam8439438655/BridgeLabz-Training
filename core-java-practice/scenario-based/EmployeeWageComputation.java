public class EmployeeWageComputation {
    public static void main(String[] args) {
        // Start
        System.out.println(" Welcome to Employee Wage Computation Program on Master Branch ");

        // Use Case 1 : Present or Absent using Random Functionality

        int isPresent = (int) Math.floor(Math.random() * 10) % 2;
        if (isPresent == 1) {
            System.out.println(" Employee is Present ");
        } else {
            System.out.println(" Employee is Absent ");
        }

        // Use Case 2 : Calculate Daily Wage

        int empRatePerHour = 20;
        int empHours = 8;
        int dailyWage = empRatePerHour * empHours;
        System.out.println(" Daily Wage of Employee is: " + dailyWage);

        // Use Case 3 : Add Part time Employee & Wage , Assume Part time Hour is 8 using random

        int isPartTime = (int) Math.floor(Math.random() * 10) % 2;
        if (isPartTime == 1) {
            empHours = 4;
        } else {
            empHours = 8;
        }
        int wage = empRatePerHour * empHours;
        System.out.println(" Employee Wage is: " + wage);
        
        // Use Case 4 : Solving usingSwitch Case Statement
        int empCheck = (int) Math.floor(Math.random() * 10) % 3;
        switch (empCheck) {
            case 0:
                empHours = 0;
                break;
            case 1:
                empHours = 4;
                break;
            case 2:
                empHours = 8;
                break;
            default:
                empHours = 0;
        }
        wage = empRatePerHour * empHours;
        System.out.println(" Employee Wage using Switch Case is: " + wage);
        
        // Use Case 5 : Calculating Wages for a Month
        
        int totalWorkingDays = 20;   // assume 20 working days
        int dailyWagee = empRatePerHour * empHours;  // reuse empRatePerHour and empHours
        int totalWageForMonth = dailyWage * totalWorkingDays;

        System.out.println(" Daily Wage: " + dailyWagee);
        System.out.println(" Total Wage for " + totalWorkingDays + " days is: " + totalWageForMonth);


        //Use Case 6 :Calculate Wages till a condition of total working hours or days is reached for a month without switch case
        int maxHoursInMonth = 100;   // maximum hours allowed
        int maxWorkingDays = 20;     // maximum days allowed
        int totalEmpHours = 0;
        int totalWorkingDaysCount = 0;
        int totalWage = 0;

        while (totalEmpHours < maxHoursInMonth && totalWorkingDaysCount < maxWorkingDays) {
            totalWorkingDaysCount++;
            totalEmpHours += empHours;   // reuse empHours (8 hours per day)
            totalWage += empRatePerHour * empHours;   
        }

        // Final output
        System.out.println(" Total Wage till condition reached: " + totalWage);
        System.out.println(" Total Hours Worked: " + totalEmpHours);
        System.out.println(" Total Days Worked: " + totalWorkingDaysCount);

    }
}
