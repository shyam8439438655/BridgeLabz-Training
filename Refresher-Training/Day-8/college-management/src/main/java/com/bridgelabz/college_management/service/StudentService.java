package com.bridgelabz.college_management.service;


import com.bridgelabz.college_management.entity.Student;
import com.bridgelabz.college_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {


    private final StudentRepository repository;


    public StudentService(StudentRepository repository){
        this.repository=repository;
    }



    // CREATE
    public Student saveStudent(Student student){

        return repository.save(student);
    }



    // READ ALL
    public List<Student> getAllStudents(){

        return repository.findAll();
    }



    // READ BY ID
    public Student getStudentById(Integer id){

        return repository.findById(id)
                .orElseThrow();
    }



    // UPDATE
    public Student updateStudent(Integer id, Student student){


        Student oldStudent=getStudentById(id);


        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        oldStudent.setGender(student.getGender());
        oldStudent.setEmail(student.getEmail());


        return repository.save(oldStudent);
    }




    // DELETE

    public void deleteStudent(Integer id){

        repository.deleteById(id);

    }


}