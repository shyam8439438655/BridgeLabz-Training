package com.example.payroll.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String department;
    private String designation;
    private Double basicSalary;
}