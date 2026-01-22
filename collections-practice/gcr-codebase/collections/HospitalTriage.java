import java.util.*;

public class HospitalTriage {

    static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Patient> pq = new PriorityQueue<>(new Comparator<Patient>() {
            public int compare(Patient a, Patient b) {
                return b.severity - a.severity; // high severity first
            }
        });

        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        while (!pq.isEmpty()) {
            Patient p = pq.remove();
            System.out.println(p.name); // Alice, John, Bob
        }
    }
}
