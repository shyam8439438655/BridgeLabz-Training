package com.bridgelabz.college_management.entity;

import com.bridgelabz.college_management.annotation.ValidGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;


    @Column(name = "roll_number", unique = true, nullable = false)
    private String rollNumber;


    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @ValidGender
    private String gender;


    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;


    private String address;


    private String city;


    private String state;


    private String course;


    private String department;


    @Column(name = "admission_year")
    private Integer admissionYear;



    // Default Constructor
    public Student() {

    }



    // Getter and Setter


    public Integer getStudentId() {
        return studentId;
    }


    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }



    public String getRollNumber() {
        return rollNumber;
    }


    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }



    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }



    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }



    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }



    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }



    public String getCourse() {
        return course;
    }


    public void setCourse(String course) {
        this.course = course;
    }



    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }



    public Integer getAdmissionYear() {
        return admissionYear;
    }


    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }


}