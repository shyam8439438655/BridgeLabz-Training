package com.example.payroll.controller;

import com.example.payroll.dto.GeneratePayrollRequest;
import com.example.payroll.entity.Payroll;
import com.example.payroll.service.PayrollService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
@RequiredArgsConstructor
public class PayrollController {

    private final PayrollService payrollService;

    // Generate (calculate + save) payroll for one employee for a given month/year
    @PostMapping("/employee/{employeeId}/generate")
    public ResponseEntity<Payroll> generatePayroll(
            @PathVariable Long employeeId,
            @Valid @RequestBody GeneratePayrollRequest request) {
        Payroll payroll = payrollService.generatePayroll(employeeId, request.getMonth(), request.getYear());
        return ResponseEntity.status(HttpStatus.CREATED).body(payroll);
    }

    // Full payroll history for one employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Payroll>> getPayrollsForEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(payrollService.getPayrollsForEmployee(employeeId));
    }

    // A specific payslip
    @GetMapping("/employee/{employeeId}/payslip")
    public ResponseEntity<Payroll> getPayslip(
            @PathVariable Long employeeId,
            @RequestParam Integer month,
            @RequestParam Integer year) {
        return ResponseEntity.ok(payrollService.getPayslip(employeeId, month, year));
    }

    // Everyone's payroll for a given month (e.g. HR running monthly report)
    @GetMapping
    public ResponseEntity<List<Payroll>> getPayrollsForMonth(
            @RequestParam Integer month,
            @RequestParam Integer year) {
        return ResponseEntity.ok(payrollService.getPayrollsForMonth(month, year));
    }

    @PatchMapping("/{payrollId}/mark-paid")
    public ResponseEntity<Payroll> markAsPaid(@PathVariable Long payrollId) {
        return ResponseEntity.ok(payrollService.markAsPaid(payrollId));
    }
}
