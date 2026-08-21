package com.example.payroll.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayrollRequestDTO {
    private Long empId;  // For identifying that which employee payroll we want to fetch
    private Integer month;
    private Integer year;

}
