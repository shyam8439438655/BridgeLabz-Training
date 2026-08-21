package com.example.payroll.controller;

import com.example.payroll.dto.PayrollRequestDTO;
import com.example.payroll.dto.PayrollResponseDTO;
import com.example.payroll.service.PayrollServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    private PayrollServiceImpl payrollService;

    public PayrollController(PayrollServiceImpl payrollService){
        this.payrollService=payrollService;
    }
    @PostMapping("/generate")
    public ResponseEntity<PayrollResponseDTO> generatePayroll(@RequestBody PayrollRequestDTO payrollRequestDTO){
        PayrollResponseDTO gen=payrollService.generate(payrollRequestDTO);
        return ResponseEntity.ok(gen);
    }

    @GetMapping("/All")
    public ResponseEntity<List<PayrollResponseDTO>> getAllPayroll(){
        List<PayrollResponseDTO>ll=payrollService.getAllPayroll();

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(ll);

    }
    @GetMapping("/{id}")
    public ResponseEntity<PayrollResponseDTO> getPayrollById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                payrollService.getPayrollById(id)
        );
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<List<PayrollResponseDTO>> findByEmpId(@PathVariable Long empId){
        List<PayrollResponseDTO> res=payrollService.findByEmplId(empId);

        return ResponseEntity.ok(res);
    }
}
