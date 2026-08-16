package com.example.payroll.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(
    name = "payrolls",
    uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id", "month", "year"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private Integer month;   // 1-12

    @Column(nullable = false)
    private Integer year;

    private Double basicSalary;
    private Double hra;
    private Double da;
    private Double grossSalary;

    // Deductions
    private Double providentFund;   // PF
    private Double professionalTax;
    private Double incomeTax;
    private Double totalDeductions;

    private Double netSalary;

    private LocalDate generatedOn = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private PayrollStatus status = PayrollStatus.GENERATED;

    public enum PayrollStatus {
        GENERATED, PAID
    }
}
