package com.bridgelabz.college_management.controller;

import com.bridgelabz.college_management.dto.StudentDTO;
import com.bridgelabz.college_management.service.StudentService;
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

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(
            @RequestBody StudentDTO studentDTO) {

        StudentDTO savedStudent =
                studentService.saveStudent(studentDTO);

        return new ResponseEntity<>(
                savedStudent,
                HttpStatus.CREATED
        );
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentDTO>> searchByFirstName(
            @RequestParam String firstName) {

        return ResponseEntity.ok(
                studentService.searchByFirstName(firstName)
        );
    }


    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {

        return new ResponseEntity<>(
                studentService.getAllStudents(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(
            @PathVariable Integer id) {

        return new ResponseEntity<>(
                studentService.getStudentById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(
            @PathVariable Integer id,
            @RequestBody StudentDTO studentDTO) {

        return new ResponseEntity<>(
                studentService.updateStudent(id, studentDTO),
                HttpStatus.OK
        );
    }

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