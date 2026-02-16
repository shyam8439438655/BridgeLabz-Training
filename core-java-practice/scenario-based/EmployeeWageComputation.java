import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeWageComputation {

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        // UC 11-14: Interface + one builder manages multiple companies + ArrayList + store daily wages + query total
        EmpWageBuilderInterface builder = new EmpWageBuilder();

        // UC 9-10: Each company has its own config (wage/day/hour) -> saved as object
        builder.addCompanyEmpWage("TCS", 20, 20, 100);
        builder.addCompanyEmpWage("INFY", 25, 22, 110);
        builder.addCompanyEmpWage("WIPRO", 18, 20, 90);

        // compute for all companies
        builder.computeEmpWage();

        // UC 14: get total wage by company
        System.out.println("\n Query Total Wage");
        System.out.println("TCS Total Wage = " + builder.getTotalWage("TCS"));
        System.out.println("INFY Total Wage = " + builder.getTotalWage("INFY"));
        System.out.println("WIPRO Total Wage = " + builder.getTotalWage("WIPRO"));
    }
}

// UC 11: Interface approach
interface EmpWageBuilderInterface {
    void addCompanyEmpWage(String companyName, int wagePerHour, int numOfWorkingDays, int maxWorkingHours);
    void computeEmpWage();
    int getTotalWage(String companyName);
}

// UC 10-14: One builder manages multiple companies
class EmpWageBuilder implements EmpWageBuilderInterface {

    // UC 12: Use ArrayList instead of array
    private final List<CompanyEmpWage> companyList = new ArrayList<>();

    // UC 14: Fast query by company
    private final Map<String, CompanyEmpWage> companyMap = new HashMap<>();

    // UC 1-6 constants (default rules)
    private static final int IS_FULL_TIME = 1;
    private static final int IS_PART_TIME = 2;

    @Override
    public void addCompanyEmpWage(String companyName, int wagePerHour, int numOfWorkingDays, int maxWorkingHours) {
        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHour, numOfWorkingDays, maxWorkingHours);
        companyList.add(company);
        companyMap.put(companyName, company);
    }

    @Override
    public void computeEmpWage() {
        for (CompanyEmpWage company : companyList) {
            computeEmpWage(company);
            System.out.println(company);
        }
    }

    // UC 7-8: Class method to compute employee wage (refactor)
    private void computeEmpWage(CompanyEmpWage company) {

        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        // UC 13: Store daily wage + total wage
        List<Integer> dailyWageList = new ArrayList<>();

        // UC 6: Till condition reached (max hours OR max days)
        while (totalEmpHrs < company.getMaxWorkingHours()
                && totalWorkingDays < company.getNumOfWorkingDays()) {

            totalWorkingDays++;

            // UC 1: Attendance check using RANDOM
            int empCheck = (int) (Math.random() * 3); // 0,1,2

            // UC 4: Switch case
            int empHrs;
            switch (empCheck) {
                case IS_FULL_TIME:
                    // UC 2: Full day = 8 hours
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    // UC 3: Part time hours (keeping practical as 4)
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
            }

            // if adding this day crosses max hours, cap it
            if (totalEmpHrs + empHrs > company.getMaxWorkingHours()) {
                empHrs = company.getMaxWorkingHours() - totalEmpHrs;
            }

            totalEmpHrs += empHrs;

            int dailyWage = empHrs * company.getWagePerHour();
            dailyWageList.add(dailyWage);
        }

        int totalWage = totalEmpHrs * company.getWagePerHour();

        company.setTotalEmpWage(totalWage);
        company.setDailyWages(dailyWageList);
        company.setTotalWorkingDays(totalWorkingDays);
        company.setTotalEmpHours(totalEmpHrs);
    }

    @Override
    public int getTotalWage(String companyName) {
        CompanyEmpWage company = companyMap.get(companyName);
        return (company == null) ? 0 : company.getTotalEmpWage();
    }
}

// CompanyEmpWage class 
class CompanyEmpWage {

    private String companyName;
    private int wagePerHour;
    private int numOfWorkingDays;
    private int maxWorkingHours;

    private int totalEmpWage;          // UC 9
    private int totalWorkingDays;      // extra info
    private int totalEmpHours;         // extra info
    private List<Integer> dailyWages;  // UC 13

    public CompanyEmpWage() {
    }

    public CompanyEmpWage(String companyName, int wagePerHour, int numOfWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.dailyWages = new ArrayList<>();
    }

    // getters/setters
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public int getWagePerHour() { return wagePerHour; }
    public void setWagePerHour(int wagePerHour) { this.wagePerHour = wagePerHour; }

    public int getNumOfWorkingDays() { return numOfWorkingDays; }
    public void setNumOfWorkingDays(int numOfWorkingDays) { this.numOfWorkingDays = numOfWorkingDays; }

    public int getMaxWorkingHours() { return maxWorkingHours; }
    public void setMaxWorkingHours(int maxWorkingHours) { this.maxWorkingHours = maxWorkingHours; }

    public int getTotalEmpWage() { return totalEmpWage; }
    public void setTotalEmpWage(int totalEmpWage) { this.totalEmpWage = totalEmpWage; }

    public int getTotalWorkingDays() { return totalWorkingDays; }
    public void setTotalWorkingDays(int totalWorkingDays) { this.totalWorkingDays = totalWorkingDays; }

    public int getTotalEmpHours() { return totalEmpHours; }
    public void setTotalEmpHours(int totalEmpHours) { this.totalEmpHours = totalEmpHours; }

    public List<Integer> getDailyWages() { return dailyWages; }
    public void setDailyWages(List<Integer> dailyWages) { this.dailyWages = dailyWages; }

    @Override
    public String toString() {
        return "\nCompany: " + companyName
                + "\nWage/Hour: " + wagePerHour
                + "\nMax Days: " + numOfWorkingDays
                + "\nMax Hours: " + maxWorkingHours
                + "\nTotal Working Days Used: " + totalWorkingDays
                + "\nTotal Hours Worked: " + totalEmpHours
                + "\nDaily Wages: " + dailyWages
                + "\nTotal Wage: " + totalEmpWage;
    }
}
