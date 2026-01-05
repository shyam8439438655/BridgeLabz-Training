interface Department {
    void assignDepartment(String deptName);
    String getDepartment();
}
abstract class Employee{
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public int setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        return baseSalary;
    }

    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    // abstract method for calculating salary
    public abstract double calculateSalary();

    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + department);
    }
}

// fulltime employee subclass
class FullTimeEmployee extends Employee implements Department {
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }
    // implementation of abstract method
    public double calculateSalary() {
        return getBaseSalary(); // for fixed salary
    }
    // implementation of interface method
    public void assignDepartment(String deptName) {
        setDepartment(deptName);
    }
}

// parttime employee subclass
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate; // for hourly wage
    }
    @Override
    public void assignDepartment(String deptName) {
        setDepartment(deptName);
    }
    
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee Emp1 = new FullTimeEmployee(1, "Chris", 60000);
        Employee Emp2 = new PartTimeEmployee(2, "Ben", 0, 120, 20);
        ((Department) Emp1).assignDepartment("HR");
        ((Department) Emp2).assignDepartment("IT");

        // Store in array
        Employee[] employees = {Emp1, Emp2};

        // Process list polymorphically
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println(((Department) emp).getDepartment());

    }
}
}