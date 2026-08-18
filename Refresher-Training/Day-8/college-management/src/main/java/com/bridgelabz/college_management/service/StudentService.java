package com.bridgelabz.college_management.service;

import com.bridgelabz.college_management.dto.StudentDTO;
import com.bridgelabz.college_management.entity.Student;
import com.bridgelabz.college_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public StudentDTO saveStudent(StudentDTO dto) {

        Student student = new Student();

        student.setRollNumber(dto.getRollNumber());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setGender(dto.getGender());
        student.setEmail(dto.getEmail());
        student.setAddress(dto.getAddress());
        student.setCity(dto.getCity());
        student.setState(dto.getState());
        student.setCourse(dto.getCourse());
        student.setDepartment(dto.getDepartment());
        student.setAdmissionYear(dto.getAdmissionYear());

        Student savedStudent = repository.save(student);

        return convertToDTO(savedStudent);
    }


    // SEARCH BY FIRST NAME
    public List<StudentDTO> searchByFirstName(String firstName) {
        return repository.findByFirstNameContainingIgnoreCase(firstName)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
    // READ ALL
    public List<StudentDTO> getAllStudents() {

        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // READ BY ID
    public StudentDTO getStudentById(Integer id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found with id: " + id
                        )
                );

        return convertToDTO(student);
    }

    // UPDATE
    public StudentDTO updateStudent(Integer id, StudentDTO dto) {

        Student oldStudent = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found with id: " + id
                        )
                );

        oldStudent.setRollNumber(dto.getRollNumber());
        oldStudent.setFirstName(dto.getFirstName());
        oldStudent.setLastName(dto.getLastName());
        oldStudent.setGender(dto.getGender());
        oldStudent.setEmail(dto.getEmail());
        oldStudent.setAddress(dto.getAddress());
        oldStudent.setCity(dto.getCity());
        oldStudent.setState(dto.getState());
        oldStudent.setCourse(dto.getCourse());
        oldStudent.setDepartment(dto.getDepartment());
        oldStudent.setAdmissionYear(dto.getAdmissionYear());

        Student updatedStudent = repository.save(oldStudent);

        return convertToDTO(updatedStudent);
    }

    // DELETE
    public void deleteStudent(Integer id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException(
                    "Student not found with id: " + id
            );
        }

        repository.deleteById(id);
    }

    // ENTITY TO DTO
    private StudentDTO convertToDTO(Student student) {

        StudentDTO dto = new StudentDTO();

        dto.setStudentId(student.getStudentId());
        dto.setRollNumber(student.getRollNumber());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setGender(student.getGender());
        dto.setEmail(student.getEmail());
        dto.setAddress(student.getAddress());
        dto.setCity(student.getCity());
        dto.setState(student.getState());
        dto.setCourse(student.getCourse());
        dto.setDepartment(student.getDepartment());
        dto.setAdmissionYear(student.getAdmissionYear());

        return dto;
    }
}