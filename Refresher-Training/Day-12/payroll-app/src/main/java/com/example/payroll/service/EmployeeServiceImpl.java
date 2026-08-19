package com.example.payroll.service;

import com.example.payroll.dto.EmployeeRequestDTO;
import com.example.payroll.dto.EmployeeResponseDTO;
import com.example.payroll.entity.Employee;
import com.example.payroll.exception.ResourceNotFoundException;
import com.example.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmplyeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public EmployeeResponseDTO create(EmployeeRequestDTO req){
        Employee emp=mapToEntity(req);
        return  mapToResponse(employeeRepository.save(emp));

    }
    @Override
    public List<EmployeeResponseDTO> getAll(){
        List<Employee> empl=employeeRepository.findAll();

        return  empl.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public EmployeeResponseDTO getEmployeeById(Long id){

        Employee e=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Contact with this" + id + "does not exist"));
        return mapToResponse(e);
    }
    @Override
    public EmployeeResponseDTO updateById(Long id,EmployeeRequestDTO req){
        Employee emp=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Contact with this" + id + "does not exist"));

        emp.setName(req.getName());
        emp.setEmail(req.getEmail());
        emp.setDepartment(req.getDepartment());
        emp.setDesignation(req.getDesignation());
        emp.setBasicSalary(req.getBasicSalary());


        return mapToResponse(employeeRepository.save(emp));

    }
    @Override
  public  List<EmployeeResponseDTO> getByDept(String department){
        List<Employee> ans= employeeRepository.findByDepartment(department);

        return ans.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
}

public void delete(Long id){
        Optional<Employee> emp=employeeRepository.findById(id);
        Employee e=emp.get();

        employeeRepository.delete(e);
}

    public EmployeeResponseDTO mapToResponse (Employee employee){

        return EmployeeResponseDTO.builder()
                .id(employee.getId())
                .name((employee.getName()))
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .designation(employee.getDesignation())
                .basicSalary(employee.getBasicSalary())
                .build();
    }
    public Employee mapToEntity(EmployeeRequestDTO res){

        return Employee.builder()
                .name(res.getName())
                .email(res.getEmail())
                .department(res.getDepartment())
                .designation(res.getDesignation())
                .basicSalary(res.getBasicSalary())
                .build();
    }

}