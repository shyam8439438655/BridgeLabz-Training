package com.example.payroll.service;

import com.example.payroll.dto.PayrollRequestDTO;
import com.example.payroll.dto.PayrollResponseDTO;
import com.example.payroll.entity.Employee;
import com.example.payroll.entity.Payroll;
import com.example.payroll.exception.ResourceNotFoundException;
import com.example.payroll.repository.EmployeeRepository;
import com.example.payroll.repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    private PayrollRepository payrollRepository;
    private EmployeeRepository employeeRepository;

    public PayrollServiceImpl(PayrollRepository payrollRepository,EmployeeRepository employeeRepository){
        this.payrollRepository=payrollRepository;
        this.employeeRepository=employeeRepository;
    }
    @Override
    public PayrollResponseDTO generate(PayrollRequestDTO req){
        Employee employee=employeeRepository.findById(req.getEmpId())
                .orElseThrow(()-> new ResourceNotFoundException("Employee with this id does not exist")
        );

        Double basicSalary=employee.getBasicSalary();
        Double hra=basicSalary*20/100;
        Double da=basicSalary*10/100;
        Double grossSalary=basicSalary+hra+da;
        Double totalDeduction=0.0; //Assume No deduction at this time

        Double netSalary=grossSalary-totalDeduction;

        Payroll pay=new Payroll();
        pay.setEmployee(employee);
        pay.setMonth(req.getMonth());
        pay.setYear(req.getYear());
        pay.setBasicSalary(basicSalary);
        pay.setHra(hra);
        pay.setDa(da);
        pay.setGrossSalary(grossSalary);
        pay.setTotalDeductions(totalDeduction);
        pay.setNetSalary(netSalary);

        Payroll pyrl=payrollRepository.save(pay);

        return mapToResponse(pyrl);


    }

    public List<PayrollResponseDTO> getAllPayroll(){
        return payrollRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<PayrollResponseDTO> findByEmplId(Long empId){
        if(!employeeRepository.existsById(empId)){
            throw new ResourceNotFoundException("Employee not exist");
        }
        return payrollRepository.findByEmployeeId(empId)
                .stream()
                .map(this::mapToResponse)
                .toList();

    }
    public  PayrollResponseDTO getPayrollById(Long id){
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Payroll not found"));

        return mapToResponse(payroll);
    }
    private PayrollResponseDTO mapToResponse(Payroll payroll){
        return PayrollResponseDTO.builder()
                .id(payroll.getId())
                .empId(payroll.getEmployee().getId())
                .employeeName(payroll.getEmployee().getName())
                .month(payroll.getMonth())
                .year(payroll.getYear())
                .basicSalary(payroll.getBasicSalary())
                .hra(payroll.getHra())
                .da(payroll.getDa())
                .grossSalary(payroll.getGrossSalary())
                .totalDeductions(payroll.getTotalDeductions())
                .netSalary(payroll.getNetSalary())
                .build();
    }
}
