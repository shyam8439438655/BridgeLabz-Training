package com.clinic.dto;

public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private int specializationId;
    private String email;

    public Doctor() {}

    public Doctor(String firstName, String lastName, int specializationId, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specializationId = specializationId;
        this.email = email;
    }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getSpecializationId() { return specializationId; }
    public void setSpecializationId(int specializationId) { this.specializationId = specializationId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Doctor [ID=" + doctorId + ", Name=" + firstName + " " + lastName + 
               ", SpecID=" + specializationId + ", Email=" + email + "]";
    }
}
