package com.bridgelabz.college_management.controller;


import com.bridgelabz.college_management.entity.Faculty;
import com.bridgelabz.college_management.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/faculty")
public class FacultyController {


    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService){

        this.facultyService = facultyService;
    }



    // CREATE

    @PostMapping
    public Faculty addFaculty(
            @Valid @RequestBody Faculty faculty){

        return facultyService.saveFaculty(faculty);
    }



    // GET ALL

    @GetMapping
    public List<Faculty> getAllFaculty(){

        return facultyService.getAllFaculty();
    }




    // GET BY ID

    @GetMapping("/{id}")
    public Faculty getFacultyById(
            @PathVariable Integer id){

        return facultyService.getFacultyById(id);
    }




    // UPDATE

    @PutMapping("/{id}")
    public Faculty updateFaculty(
            @PathVariable Integer id,
            @RequestBody Faculty faculty){

        return facultyService.updateFaculty(id,faculty);
    }




    // DELETE

    @DeleteMapping("/{id}")
    public String deleteFaculty(
            @PathVariable Integer id){

        facultyService.deleteFaculty(id);

        return "Faculty deleted successfully";
    }

}