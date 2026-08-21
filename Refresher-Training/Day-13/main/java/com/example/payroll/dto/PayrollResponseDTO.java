package com.example.payroll.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayrollResponseDTO {

    private Long id;
    private Long empId;
    private String employeeName;
    private Integer month;
    private Integer year;
    private Double basicSalary;
    private Double hra;
    private Double da;
    private Double grossSalary;
    private Double totalDeductions;
    private Double netSalary;
}
