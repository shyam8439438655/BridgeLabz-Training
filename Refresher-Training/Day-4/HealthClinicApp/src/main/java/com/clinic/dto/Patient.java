package com.clinic.dto;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private String email;

    public Patient() {}

    public Patient(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Patient [ID=" + patientId + ", Name=" + firstName + " " + lastName + ", Email=" + email + "]";
    }
}
