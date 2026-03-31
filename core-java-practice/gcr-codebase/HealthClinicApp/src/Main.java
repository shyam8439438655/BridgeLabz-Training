import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Health Clinic App ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Book Appointment");
            System.out.println("3. View Patient Visit History");
            System.out.println("4. Add Doctor");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("DOB (yyyy-mm-dd): "); String dob = sc.nextLine();
                    System.out.print("Phone: "); String phone = sc.nextLine();
                    System.out.print("Address: "); String address = sc.nextLine();
                    System.out.print("Blood Group: "); String bg = sc.nextLine();
                    PatientService.registerPatient(name, dob, phone, address, bg);
                    break;

                case 2:
                    System.out.print("Patient ID: "); int pid = sc.nextInt();
                    System.out.print("Doctor ID: "); int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Date (yyyy-mm-dd): "); String date = sc.nextLine();
                    System.out.print("Time (HH:mm:ss): "); String time = sc.nextLine();
                    AppointmentService.bookAppointment(pid, did, date, time);
                    break;

                case 3:
                    System.out.print("Patient ID: "); int pid2 = sc.nextInt();
                    PatientService.viewVisitHistory(pid2);
                    break;

                case 4:
                    System.out.print("Doctor Name: "); String dname = sc.nextLine();
                    System.out.print("Specialty ID: "); int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Contact: "); String contact = sc.nextLine();
                    System.out.print("Fee: "); double fee = sc.nextDouble();
                    DoctorService.addDoctor(dname, sid, contact, fee);
                    break;

                case 5:
                    System.out.print("Visit ID: "); int vid = sc.nextInt();
                    System.out.print("Amount: "); double amount = sc.nextDouble();
                    BillingService.generateBill(vid, amount);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
