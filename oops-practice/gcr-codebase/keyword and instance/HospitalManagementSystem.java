class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    final String patientID;
    String name;
    int age;
    String ailment;

    Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("P001", "Lathika", 30, "Flu");
        Patient p2 = new Patient("P002", "Lidiya", 45, "Fracture");

        Patient.getTotalPatients();
        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
    }
}