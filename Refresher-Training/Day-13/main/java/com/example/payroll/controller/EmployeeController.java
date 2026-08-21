package com.example.payroll.controller;
import com.example.payroll.dto.EmployeeRequestDTO;
import com.example.payroll.dto.EmployeeResponseDTO;
import com.example.payroll.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
       EmployeeResponseDTO res =employeeService.create(employeeRequestDTO);

       return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDTO>> getAll(){
        List<EmployeeResponseDTO>ll=employeeService.getAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(ll);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(@PathVariable Long id,@RequestBody EmployeeRequestDTO req){
         EmployeeResponseDTO res=employeeService.updateById(id,req);

         return ResponseEntity.status(HttpStatus.OK).body(res);

    }
    @GetMapping("/department/{department}")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeeByDepartment(
            @PathVariable String department) {

        List<EmployeeResponseDTO>ll=employeeService.getByDept(department);

        return ResponseEntity.status(HttpStatus.OK).body(ll);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        employeeService.delete(id);
        return
                ResponseEntity.ok("Data Deleted");
    }

}
