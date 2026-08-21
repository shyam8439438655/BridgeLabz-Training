package com.example.payroll.service;

import com.example.payroll.dto.EmployeeRequestDTO;
import com.example.payroll.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmplyeeService {
    public EmployeeResponseDTO create(EmployeeRequestDTO req);
    public List<EmployeeResponseDTO> getAll();
    public EmployeeResponseDTO getEmployeeById(Long id);
    public EmployeeResponseDTO updateById(Long id,EmployeeRequestDTO req);
    public  List<EmployeeResponseDTO> getByDept(String department);
}
