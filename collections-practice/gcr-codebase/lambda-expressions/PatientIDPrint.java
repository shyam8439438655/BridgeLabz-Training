import java.util.*;

public class PatientIDPrint {
    public static void main(String[] args) {

        List<String> patientIds = Arrays.asList("P101", "P102", "P103");

        // Method reference
        patientIds.forEach(System.out::println);
    }
}
