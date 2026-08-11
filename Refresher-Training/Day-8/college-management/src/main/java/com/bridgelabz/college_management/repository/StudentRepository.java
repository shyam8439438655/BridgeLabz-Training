package com.bridgelabz.college_management.repository;


import com.bridgelabz.college_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository
        extends JpaRepository<Student,Integer> {


}