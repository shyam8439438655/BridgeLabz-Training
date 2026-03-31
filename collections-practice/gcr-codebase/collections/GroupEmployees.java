import java.util.*;

public class GroupEmployees {

    static class Employee {
        String name;
        String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees) {
            if (!map.containsKey(e.department)) {
                map.put(e.department, new ArrayList<>());
            }
            map.get(e.department).add(e);
        }

        for (String dept : map.keySet()) {
            System.out.println(dept + " : " + map.get(dept));
        }
    }
}
