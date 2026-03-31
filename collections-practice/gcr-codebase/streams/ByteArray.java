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
}

public class ByteArray {
    public static void main(String[] args) {

        String file = "emp.dat";

        // SAVE (Serialization)
        try {
            ArrayList<Employee> list = new ArrayList<>();
            list.add(new Employee(1, "Aman", "IT", 50000));
            list.add(new Employee(2, "Neha", "HR", 40000));

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(list);
            out.close();

            System.out.println("Employees saved in file");
        } catch (IOException e) {
            System.out.println("Error while saving");
        }

        // READ (Deserialization)
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Employee> list = (ArrayList<Employee>) in.readObject();
            in.close();

            System.out.println("Employees from file:");
            for (Employee e : list) {
                System.out.println(e.id + " " + e.name + " " + e.department + " " + e.salary);
            }
        } catch (IOException e) {
            System.out.println("Error while reading");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
}
