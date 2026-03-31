class Employee {
    // Attributes (variables)
    String name;
    int id;
    double salary;

    // Constructor to initialize employee details
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }
}
// Main class
public class EmployeeDetails {
    public static void main(String[] args) {
        // Create an Employee object
        Employee emp1 = new Employee("Rohan", 1, 500000);

        // Call method to display details
        emp1.displayDetails();
    }
}