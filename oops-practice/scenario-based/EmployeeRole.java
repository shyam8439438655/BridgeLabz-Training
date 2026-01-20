abstract class Employee {

    // immutable core data
    private final String name;
    private final double salary;

    // constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    
    public double getSalary() {
        return salary;
    }

    // abstract method (polymorphism)
    abstract double getBonus();
}
// Manager class
class Manager extends Employee {
    private final double bonus; 

    Manager(String name, double salary) {
        super(name, salary);
        this.bonus = calculateBonus();
    }

    private double calculateBonus() {
        return getSalary() * 0.10;
    }

    @Override
    double getBonus() {
        return bonus;
    }
}
// Developer class
class Developer extends Employee {
    private final double bonus; // cached bonus

    Developer(String name, double salary) {
        super(name, salary);
        this.bonus = calculateBonus();
    }

    private double calculateBonus() {
        if (getSalary() > 50000) {
            return getSalary() * 0.05;
        }
        return 0.0;
    }

    @Override
    double getBonus() {
        return bonus;
    }
}

public class EmployeeRole {
    public static void main(String[] args) {

        Employee manager = new Manager("Alice", 80000);
        System.out.printf("%.2f%n", manager.getBonus()); // 8000.00

        Employee developer1 = new Developer("Bob", 60000);
        System.out.printf("%.2f%n", developer1.getBonus()); // 3000.00

        Employee developer2 = new Developer("Charlie", 40000);
        System.out.printf("%.2f%n", developer2.getBonus()); // 0.00
    }
}
