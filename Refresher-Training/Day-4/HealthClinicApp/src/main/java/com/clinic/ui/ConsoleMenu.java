package com.clinic.ui;

import com.clinic.dao.*;
import com.clinic.dto.*;
import com.clinic.service.AppointmentService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private final Scanner scanner = new Scanner(System.in);
    
    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Register Patient");
            System.out.println("2. Add Specialization");
            System.out.println("3. Register Doctor");
            System.out.println("4. Book Appointment");
            System.out.println("5. Complete Appointment");
            System.out.println("6. View all data (Patients, Doctors, Appointments)");
            System.out.println("7. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear leftover newline
            
            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> addSpecialization();
                case 3 -> registerDoctor();
                case 4 -> bookAppointment();
                case 5 -> completeAppointment();
                case 6 -> viewData();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void registerPatient() {
        System.out.print("First name: ");
        String first = scanner.nextLine();
        System.out.print("Last name: ");
        String last = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Patient p = new Patient(first, last, email);
        int id = patientDAO.insertPatient(p);
        
        if (id > 0) {
            System.out.println("Registered with ID: " + id);
        } else {
            System.out.println("Registration failed.");
        }
    }
    
    private void addSpecialization() {
        System.out.print("Specialization Name: ");
        String name = scanner.nextLine();
        
        Specialization spec = new Specialization(name);
        int id = specializationDAO.insertSpecialization(spec);
        
        if (id > 0) {
            System.out.println("Specialization added successfully with ID: " + id);
        } else {
            System.out.println("Failed to add specialization.");
        }
    }

    private void registerDoctor() {
        System.out.print("Doctor First name: ");
        String first = scanner.nextLine();
        System.out.print("Doctor Last name: ");
        String last = scanner.nextLine();
        
        System.out.println("Available Specializations:");
        List<Specialization> specs = specializationDAO.getAllSpecializations();
        for (int i = 0; i < specs.size(); i++) {
            Specialization s = specs.get(i);
            System.out.println(s.getSpecializationId() + " - " + s.getName());
        }
        
        System.out.print("Enter Specialization ID from above: ");
        int specId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Doctor d = new Doctor(first, last, specId, email);
        int id = doctorDAO.insertDoctor(d);
        
        if (id > 0) {
            System.out.println("Doctor registered successfully. ID: " + id);
        } else {
            System.out.println("Registration failed.");
        }
    }

    private void bookAppointment() {
        System.out.print("Patient ID: ");
        int pId = scanner.nextInt();
        System.out.print("Doctor ID: ");
        int dId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Appointment Date (yyyy-MM-dd HH:mm): ");
        String dateStr = scanner.nextLine();
        
        try {
            LocalDateTime dt = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            Appointment a = new Appointment(pId, dId, dt, "Scheduled");
            int id = appointmentDAO.insertAppointment(a);
            
            if (id > 0) {
                System.out.println("Appointment booked with ID: " + id);
            } else {
                System.out.println("Booking failed.");
            }
        } catch (Exception e) {
            System.out.println("Invalid date format! Try something like 2024-12-01 14:30");
        }
    }

    private void completeAppointment() {
        System.out.print("Appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Bill amount: ");
        String amountStr = scanner.nextLine();
        BigDecimal amount = new BigDecimal(amountStr);
        
        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();
        
        boolean success = appointmentService.completeAppointment(id, amount, diagnosis);
        if (success) {
            System.out.println("Appointment completed!");
        } else {
            System.out.println("Something went wrong.");
        }
    }
    
    private void viewData() {
        System.out.println("\n--- Registered Patients ---");
        List<Patient> patients = patientDAO.getAllPatients();
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            System.out.println("ID: " + p.getPatientId() + ", Name: " + p.getFirstName() + " " + p.getLastName() + ", Email: " + p.getEmail());
        }
        
        System.out.println("\n--- Registered Doctors ---");
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        for (int i = 0; i < doctors.size(); i++) {
            Doctor d = doctors.get(i);
            System.out.println("ID: " + d.getDoctorId() + ", Name: Dr. " + d.getFirstName() + " " + d.getLastName() + " (Specialization ID: " + d.getSpecializationId() + ")");
        }
        
        System.out.println("\n--- Appointments ---");
        List<Appointment> apps = appointmentDAO.getAllAppointments();
        for (int i = 0; i < apps.size(); i++) {
            Appointment a = apps.get(i);
            System.out.println("Appt ID: " + a.getAppointmentId() + " | Patient: " + a.getPatientId() + " | Doctor: " + a.getDoctorId() + " | Status: " + a.getStatus());
        }
    }
}
