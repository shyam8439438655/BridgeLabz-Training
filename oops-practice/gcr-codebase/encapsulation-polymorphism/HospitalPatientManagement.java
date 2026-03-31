interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    // sensitive details encapsulated
    private String diagnosis;
    private String medicalHistory;

    public Patient(int patientId, String name, int age, String diagnosis, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // encapsulated sensitive info
    protected String getDiagnosis() {
        return diagnosis;
    }

    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getMedicalHistory() {
        return medicalHistory;
    }

    protected void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // abstract method
    public abstract double calculateBill();

    // concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId +
                           ", Name: " + name +
                           ", Age: " + age +
                           ", Bill: " + calculateBill());
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private double treatmentCharge;
    private String record;

    public InPatient(int patientId, String name, int age, String diagnosis, String medicalHistory,
                     double roomCharge, double treatmentCharge) {
        super(patientId, name, age, diagnosis, medicalHistory);
        this.roomCharge = roomCharge;
        this.treatmentCharge = treatmentCharge;
    }

    @Override
    public double calculateBill() {
        // InPatients: room charge + treatment charge
        return roomCharge + treatmentCharge;
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
        System.out.println("InPatient record added: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("InPatient Medical Record: " + record);
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String record;

    public OutPatient(int patientId, String name, int age, String diagnosis, String medicalHistory,
                      double consultationFee) {
        super(patientId, name, age, diagnosis, medicalHistory);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        // OutPatients: consultation fee only
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
        System.out.println("OutPatient record added: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("OutPatient Medical Record: " + record);
    }
}

// Main class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient p1 = new InPatient(101, "Shyam", 30, "Fever", "No major history", 5000, 2000);
        Patient p2 = new OutPatient(102, "Ravi", 25, "Cold", "Allergy history", 500);

        Patient[] patients = {p1, p2};

        for (Patient p : patients) {
            p.getPatientDetails();
            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                mr.addRecord("Follow-up scheduled.");
                mr.viewRecords();
            }
            System.out.println("-------------------------");
        }
    }
}