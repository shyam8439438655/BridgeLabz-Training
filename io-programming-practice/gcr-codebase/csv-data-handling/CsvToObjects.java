import java.io.*;
import java.util.*;

class Student {
    int id, age, marks;
    String name;

    Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toString() {
        return "Student{id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks + "}";
    }
}

public class CsvToObjects {
    public static void main(String[] args) throws Exception {

        List<Student> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine(); // skip header
        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            int id = Integer.parseInt(d[0]);
            String name = d[1];
            int age = Integer.parseInt(d[2]);
            int marks = Integer.parseInt(d[3]);

            list.add(new Student(id, name, age, marks));
        }

        br.close();

        for (Student s : list) {
            System.out.println(s);
        }
    }
}
