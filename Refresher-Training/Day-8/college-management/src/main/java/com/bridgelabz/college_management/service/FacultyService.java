package com.bridgelabz.college_management.service;

import com.bridgelabz.college_management.dto.FacultyDTO;
import com.bridgelabz.college_management.entity.Faculty;
import com.bridgelabz.college_management.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    // CREATE
    public FacultyDTO saveFaculty(FacultyDTO dto) {

        Faculty faculty = new Faculty();

        faculty.setFirstName(dto.getFirstName());
        faculty.setLastName(dto.getLastName());
        faculty.setGender(dto.getGender());
        faculty.setEmail(dto.getEmail());
        faculty.setAddress(dto.getAddress());
        faculty.setCity(dto.getCity());
        faculty.setState(dto.getState());
        faculty.setDepartment(dto.getDepartment());
        faculty.setDesignation(dto.getDesignation());
        faculty.setJoiningYear(dto.getJoiningYear());

        Faculty savedFaculty = facultyRepository.save(faculty);

        return convertToDTO(savedFaculty);
    }

    // READ ALL
    public List<FacultyDTO> getAllFaculties() {

        return facultyRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // READ BY ID
    public FacultyDTO getFacultyById(Integer id) {

        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Faculty not found with id: " + id
                        )
                );

        return convertToDTO(faculty);
    }

    // UPDATE
    public FacultyDTO updateFaculty(Integer id, FacultyDTO dto) {

        Faculty oldFaculty = facultyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Faculty not found with id: " + id
                        )
                );

        oldFaculty.setFirstName(dto.getFirstName());
        oldFaculty.setLastName(dto.getLastName());
        oldFaculty.setGender(dto.getGender());
        oldFaculty.setEmail(dto.getEmail());
        oldFaculty.setAddress(dto.getAddress());
        oldFaculty.setCity(dto.getCity());
        oldFaculty.setState(dto.getState());
        oldFaculty.setDepartment(dto.getDepartment());
        oldFaculty.setDesignation(dto.getDesignation());
        oldFaculty.setJoiningYear(dto.getJoiningYear());

        Faculty updatedFaculty =
                facultyRepository.save(oldFaculty);

        return convertToDTO(updatedFaculty);
    }

    // DELETE
    public void deleteFaculty(Integer id) {

        if (!facultyRepository.existsById(id)) {
            throw new RuntimeException(
                    "Faculty not found with id: " + id
            );
        }

        facultyRepository.deleteById(id);
    }

    // ENTITY TO DTO
    private FacultyDTO convertToDTO(Faculty faculty) {

        FacultyDTO dto = new FacultyDTO();

        dto.setFacultyId(faculty.getFacultyId());
        dto.setFirstName(faculty.getFirstName());
        dto.setLastName(faculty.getLastName());
        dto.setGender(faculty.getGender());
        dto.setEmail(faculty.getEmail());
        dto.setAddress(faculty.getAddress());
        dto.setCity(faculty.getCity());
        dto.setState(faculty.getState());
        dto.setDepartment(faculty.getDepartment());
        dto.setDesignation(faculty.getDesignation());
        dto.setJoiningYear(faculty.getJoiningYear());

        return dto;
    }
}