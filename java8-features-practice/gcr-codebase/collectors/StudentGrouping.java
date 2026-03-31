import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    String grade;

    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    String getName() {
        return name;
    }

    String getGrade() {
        return grade;
    }
}

public class StudentGrouping {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Rahul", "A"),
            new Student("Aman", "B"),
            new Student("Neha", "A"),
            new Student("Priya", "C"),
            new Student("Rohit", "B")
        );

        // Group students by grade and collect names
        Map<String, List<String>> result =
            students.stream().collect(Collectors.groupingBy(Student::getGrade,Collectors.mapping(Student::getName, Collectors.toList())));

        System.out.println(result);
    }
}
