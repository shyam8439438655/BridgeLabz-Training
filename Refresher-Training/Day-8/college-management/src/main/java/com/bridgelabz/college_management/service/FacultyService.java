package com.bridgelabz.college_management.service;


import com.bridgelabz.college_management.entity.Faculty;
import com.bridgelabz.college_management.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacultyService {


    private final FacultyRepository facultyRepository;


    public FacultyService(FacultyRepository facultyRepository){

        this.facultyRepository = facultyRepository;
    }



    // CREATE

    public Faculty saveFaculty(Faculty faculty){

        return facultyRepository.save(faculty);
    }



    // READ ALL

    public List<Faculty> getAllFaculty(){

        return facultyRepository.findAll();
    }



    // READ BY ID

    public Faculty getFacultyById(Integer id){

        return facultyRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Faculty not found")
                );
    }



    // UPDATE

    public Faculty updateFaculty(Integer id, Faculty faculty){


        Faculty oldFaculty = getFacultyById(id);


        oldFaculty.setFirstName(faculty.getFirstName());

        oldFaculty.setLastName(faculty.getLastName());

        oldFaculty.setGender(faculty.getGender());

        oldFaculty.setEmail(faculty.getEmail());

        oldFaculty.setAddress(faculty.getAddress());

        oldFaculty.setCity(faculty.getCity());

        oldFaculty.setState(faculty.getState());

        oldFaculty.setDepartment(faculty.getDepartment());

        oldFaculty.setDesignation(faculty.getDesignation());

        oldFaculty.setJoiningYear(faculty.getJoiningYear());


        return facultyRepository.save(oldFaculty);
    }



    // DELETE

    public void deleteFaculty(Integer id){

        facultyRepository.deleteById(id);
    }

}