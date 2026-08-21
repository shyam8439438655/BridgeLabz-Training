package com.example.payroll.service;

import com.example.payroll.dto.PayrollRequestDTO;
import com.example.payroll.dto.PayrollResponseDTO;

import java.util.List;

public interface PayrollService {
    public PayrollResponseDTO generate(PayrollRequestDTO req);
    public List<PayrollResponseDTO> getAllPayroll();
    public List<PayrollResponseDTO> findByEmplId(Long empId);
    public  PayrollResponseDTO getPayrollById(Long id);
}
