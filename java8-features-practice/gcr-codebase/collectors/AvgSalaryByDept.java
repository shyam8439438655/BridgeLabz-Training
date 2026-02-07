import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class AvgSalaryByDept {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Aman", "IT", 60000),
                new Employee("Riya", "IT", 80000),
                new Employee("Kunal", "HR", 50000),
                new Employee("Neha", "HR", 70000),
                new Employee("Pooja", "Sales", 65000)
        );

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println(avgSalaryByDept);
    }
}
