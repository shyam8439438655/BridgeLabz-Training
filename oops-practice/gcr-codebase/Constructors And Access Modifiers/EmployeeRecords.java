class Employee {
    // Public member
    public int employeeID;

    // Protected member (accessible in subclasses)
    protected String department;

    // Private member (only accessible inside Employee class)
    private double salary;

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    // Public method to set salary
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            System.out.println("Salary updated to: " + salary);
        } else {
            System.out.println("Invalid salary amount!");
        }
    }

    // Display employee details
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {
    private String teamName;

    // Constructor
    public Manager(int employeeID, String department, double salary, String teamName) {
        // Call parent constructor
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    // Demonstrating access to public (employeeID) and protected (department)
    public void displayManagerInfo() {
        System.out.println("Manager Employee ID (public): " + employeeID);
        System.out.println("Manager Department (protected): " + department);
        System.out.println("Manager Salary (via getter): " + getSalary());
        System.out.println("Team Name: " + teamName);
    }
}

// Main class to test
public class EmployeeRecords {
    public static void main(String[] args) {
        // Create an Employee object
        Employee emp1 = new Employee(101, "HR", 30000.0);
        emp1.displayEmployeeInfo();

        // Modify salary using setter
        emp1.setSalary(35000.0);
        System.out.println("Updated Salary: " + emp1.getSalary());

        System.out.println("-----------------------------");

        // Create a Manager object
        Manager mgr1 = new Manager(201, "IT", 60000.0, "Development Team");
        mgr1.displayManagerInfo();
    }
}