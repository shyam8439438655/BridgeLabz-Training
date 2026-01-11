import java.util.ArrayList;
import java.util.Scanner;

// Abstraction
interface IPayable {
    double calculateBill();
}

//  PATIENT 
class Patient {
    private int id;
    private String name;
    private int age;
    private Doctor doctor;

    Patient(int id, String name, int age, Doctor doctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
    }

    int getId() {
        return id;
    }

    void displayInfo() {
        System.out.println("Patient ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        doctor.displayDoctor();
    }
}

//  DOCTOR 
class Doctor {
    private String name;
    private String specialization;

    Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    void displayDoctor() {
        System.out.println("Doctor     : " + name);
        System.out.println("Speciality : " + specialization);
    }
}

//  IN-PATIENT 
class InPatient extends Patient implements IPayable {

    private int days;
    private double dailyCharge;

    InPatient(int id, String name, int age, Doctor doctor,
              int days, double dailyCharge) {

        super(id, name, age, doctor);
        this.days = days;
        this.dailyCharge = dailyCharge;
    }

    public double calculateBill() {
        return days * dailyCharge;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Patient Type : In-Patient");
        System.out.println("Bill Amount : ₹" + calculateBill());
    }
}

//  OUT-PATIENT 
class OutPatient extends Patient implements IPayable {

    private double consultationFee;

    OutPatient(int id, String name, int age, Doctor doctor,
               double consultationFee) {

        super(id, name, age, doctor);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Patient Type : Out-Patient");
        System.out.println("Bill Amount : ₹" + calculateBill());
    }
}

//  MAIN CLASS 
public class HospitalPatientManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n--- Hospital Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addPatient();
            } 
            else if (choice == 2) {
                viewPatients();
            } 
            else if (choice == 3) {
                deletePatient();
            } 
            else if (choice == 4) {
                System.out.println("Program Closed.");
            } 
            else {
                System.out.println("Invalid Choice!");
            }
        }
    }

    // ADD 
    static void addPatient() {

        System.out.print("Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        // Doctor details
        System.out.print("Doctor Name: ");
        String dName = sc.nextLine();

        System.out.print("Doctor Specialization: ");
        String spec = sc.nextLine();

        Doctor doctor = new Doctor(dName, spec);

        System.out.print("1. In-Patient  2. Out-Patient : ");
        int type = sc.nextInt();

        if (type == 1) {

            System.out.print("Days Admitted: ");
            int days = sc.nextInt();

            System.out.print("Daily Charge: ");
            double charge = sc.nextDouble();

            patients.add(new InPatient(id, name, age, doctor, days, charge));
        } 
        else {

            System.out.print("Consultation Fee: ");
            double fee = sc.nextDouble();

            patients.add(new OutPatient(id, name, age, doctor, fee));
        }

        System.out.println("Patient Added Successfully!");
    }

    //  VIEW 
    static void viewPatients() {

        if (patients.size() == 0) {
            System.out.println("No Patients Found!");
            return;
        }

        for (Patient p : patients) {
            System.out.println("--------------------------");
            p.displayInfo(); // POLYMORPHISM
        }
    }

    // DELETE 
    static void deletePatient() {

        System.out.print("Enter Patient ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                patients.remove(i);
                found = true;
                break;
            }
        }

        if (found)
            System.out.println("Patient Deleted!");
        else
            System.out.println("Patient Not Found!");
    }
}
