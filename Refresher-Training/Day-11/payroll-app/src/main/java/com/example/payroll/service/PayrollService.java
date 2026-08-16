package com.example.payroll.service;

import com.example.payroll.entity.Employee;
import com.example.payroll.entity.Payroll;
import com.example.payroll.exception.DuplicateResourceException;
import com.example.payroll.exception.ResourceNotFoundException;
import com.example.payroll.repository.PayrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayrollService {

    private final PayrollRepository payrollRepository;
    private final EmployeeService employeeService;

    // Simple, adjustable deduction rules — kept as constants so they're
    // easy to explain/tweak for a learning project.
    private static final double PF_PERCENT_OF_BASIC = 12.0;      // Provident Fund
    private static final double PROFESSIONAL_TAX_FLAT = 200.0;    // flat monthly amount
    private static final double INCOME_TAX_THRESHOLD_ANNUAL = 500000.0; // no tax below this annual gross
    private static final double INCOME_TAX_PERCENT = 10.0;        // flat slab above threshold, for simplicity

    @Transactional
    public Payroll generatePayroll(Long employeeId, Integer month, Integer year) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        payrollRepository.findByEmployeeIdAndMonthAndYear(employeeId, month, year)
                .ifPresent(p -> {
                    throw new DuplicateResourceException(
                            "Payroll already generated for employee " + employeeId
                                    + " for " + month + "/" + year);
                });

        double basic = employee.getBasicSalary();
        double hra = round(basic * employee.getHraPercent() / 100.0);
        double da = round(basic * employee.getDaPercent() / 100.0);
        double gross = round(basic + hra + da);

        double pf = round(basic * PF_PERCENT_OF_BASIC / 100.0);
        double professionalTax = PROFESSIONAL_TAX_FLAT;
        double incomeTax = calculateMonthlyIncomeTax(gross);

        double totalDeductions = round(pf + professionalTax + incomeTax);
        double netSalary = round(gross - totalDeductions);

        Payroll payroll = new Payroll();
        payroll.setEmployee(employee);
        payroll.setMonth(month);
        payroll.setYear(year);
        payroll.setBasicSalary(basic);
        payroll.setHra(hra);
        payroll.setDa(da);
        payroll.setGrossSalary(gross);
        payroll.setProvidentFund(pf);
        payroll.setProfessionalTax(professionalTax);
        payroll.setIncomeTax(incomeTax);
        payroll.setTotalDeductions(totalDeductions);
        payroll.setNetSalary(netSalary);

        return payrollRepository.save(payroll);
    }

    public List<Payroll> getPayrollsForEmployee(Long employeeId) {
        // ensures employee exists, else 404
        employeeService.getEmployeeById(employeeId);
        return payrollRepository.findByEmployeeId(employeeId);
    }

    public Payroll getPayslip(Long employeeId, Integer month, Integer year) {
        return payrollRepository.findByEmployeeIdAndMonthAndYear(employeeId, month, year)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No payroll found for employee " + employeeId + " for " + month + "/" + year));
    }

    public List<Payroll> getPayrollsForMonth(Integer month, Integer year) {
        return payrollRepository.findByMonthAndYear(month, year);
    }

    public Payroll markAsPaid(Long payrollId) {
        Payroll payroll = payrollRepository.findById(payrollId)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll not found with id: " + payrollId));
        payroll.setStatus(Payroll.PayrollStatus.PAID);
        return payrollRepository.save(payroll);
    }

    // Very simplified monthly tax estimate: annualize the gross, apply a flat
    // percentage above a threshold, then bring it back to a monthly figure.
    private double calculateMonthlyIncomeTax(double monthlyGross) {
        double annualGross = monthlyGross * 12;
        if (annualGross <= INCOME_TAX_THRESHOLD_ANNUAL) {
            return 0.0;
        }
        double taxableAnnual = annualGross - INCOME_TAX_THRESHOLD_ANNUAL;
        double annualTax = taxableAnnual * INCOME_TAX_PERCENT / 100.0;
        return round(annualTax / 12);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
