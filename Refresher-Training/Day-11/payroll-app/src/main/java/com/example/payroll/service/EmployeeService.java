package com.example.payroll.service;

import com.example.payroll.dto.EmployeeRequest;
import com.example.payroll.entity.Employee;
import com.example.payroll.exception.DuplicateResourceException;
import com.example.payroll.exception.ResourceNotFoundException;
import com.example.payroll.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public Employee createEmployee(EmployeeRequest request) {
        if (employeeRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("An employee with email '" + request.getEmail() + "' already exists");
        }

        Employee employee = new Employee();
        applyRequestToEntity(request, employee);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getActiveEmployees() {
        return employeeRepository.findByActiveTrue();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartmentIgnoreCase(department);
    }

    @Transactional
    public Employee updateEmployee(Long id, EmployeeRequest request) {
        Employee employee = getEmployeeById(id);

        // If email changed, ensure the new one isn't already taken by someone else
        if (!employee.getEmail().equalsIgnoreCase(request.getEmail())
                && employeeRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("An employee with email '" + request.getEmail() + "' already exists");
        }

        applyRequestToEntity(request, employee);
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deactivateEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employee.setActive(false);
        employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }

    private void applyRequestToEntity(EmployeeRequest request, Employee employee) {
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setDepartment(request.getDepartment());
        employee.setDesignation(request.getDesignation());
        employee.setBasicSalary(request.getBasicSalary());
        employee.setHraPercent(request.getHraPercent() != null ? request.getHraPercent() : 20.0);
        employee.setDaPercent(request.getDaPercent() != null ? request.getDaPercent() : 10.0);
    }
}
