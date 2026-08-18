package com.bridgelabz.college_management.repository;

import com.bridgelabz.college_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
     List<Student> findByFirstNameContainingIgnoreCase(String firstname);

}