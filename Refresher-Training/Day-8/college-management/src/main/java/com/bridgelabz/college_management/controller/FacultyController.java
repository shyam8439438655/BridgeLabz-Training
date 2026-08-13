package com.bridgelabz.college_management.controller;

import com.bridgelabz.college_management.dto.FacultyDTO;
import com.bridgelabz.college_management.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<FacultyDTO> addFaculty(
            @RequestBody FacultyDTO facultyDTO) {

        FacultyDTO savedFaculty =
                facultyService.saveFaculty(facultyDTO);

        return new ResponseEntity<>(
                savedFaculty,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<FacultyDTO>> getAllFaculties() {

        return new ResponseEntity<>(
                facultyService.getAllFaculties(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDTO> getFacultyById(
            @PathVariable Integer id) {

        return new ResponseEntity<>(
                facultyService.getFacultyById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyDTO> updateFaculty(
            @PathVariable Integer id,
            @RequestBody FacultyDTO facultyDTO) {

        return new ResponseEntity<>(
                facultyService.updateFaculty(id, facultyDTO),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(
            @PathVariable Integer id) {

        facultyService.deleteFaculty(id);

        return new ResponseEntity<>(
                "Faculty deleted successfully",
                HttpStatus.OK
        );
    }
}