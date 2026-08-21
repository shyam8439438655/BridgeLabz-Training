package com.example.payroll.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name="Payroll",
        uniqueConstraints=@UniqueConstraint(columnNames = {"employee_id","month","year"}
        )
)
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private Integer month;

    @Column(nullable = false)
    private Integer year;

    private Double basicSalary;
    private Double hra;
    private Double da;
    private Double grossSalary;
    private Double totalDeductions;
    private Double netSalary;
}
