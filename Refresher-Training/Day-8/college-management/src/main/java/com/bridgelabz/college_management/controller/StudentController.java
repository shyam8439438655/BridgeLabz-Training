package com.bridgelabz.college_management.controller;


import com.bridgelabz.college_management.entity.Student;
import com.bridgelabz.college_management.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;



    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }



    // CREATE STUDENT
    @PostMapping
    public ResponseEntity<Student> addStudent(
            @Valid @RequestBody Student student) {

        Student savedStudent = studentService.saveStudent(student);

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }




    // GET ALL STUDENTS
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> students = studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }





    // GET STUDENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable Integer id) {


        Student student = studentService.getStudentById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }





    // UPDATE STUDENT
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Integer id,
            @Valid @RequestBody Student student) {


        Student updatedStudent =
                studentService.updateStudent(id, student);


        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }





    // DELETE STUDENT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Integer id) {


        studentService.deleteStudent(id);


        return new ResponseEntity<>(
                "Student deleted successfully",
                HttpStatus.OK
        );
    }

}