import java.io.*;
import java.util.*;

// Employee class
class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void show() {
        System.out.println(id + "  " + name + "  " + department + "  " + salary);
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {

        String fileName = "employee.dat";

        try {
            ArrayList<Employee> list = new ArrayList<>();

            list.add(new Employee(1, "Aman", "IT", 50000));
            list.add(new Employee(2, "Neha", "HR", 45000));
            list.add(new Employee(3, "Rohit", "Sales", 40000));

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(fileName));

            oos.writeObject(list);   // list file me save ho rahi hai
            oos.close();

            System.out.println("Employees saved successfully!");

        } catch (IOException e) {
            System.out.println("Saving error: " + e.getMessage());
        }

        
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(fileName));

            ArrayList<Employee> list =
                    (ArrayList<Employee>) ois.readObject();

            ois.close();

            System.out.println("\nEmployees read from file:");
            for (Employee e : list) {
                e.show();
            }

        } catch (IOException e) {
            System.out.println("Reading error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
