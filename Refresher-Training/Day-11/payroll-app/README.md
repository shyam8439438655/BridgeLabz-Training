# Employee Payroll App

A REST API built with **Spring Boot 3** + **Spring Data JPA** for managing employees and generating monthly payroll (payslips) with automatic salary calculations.

## Tech Stack
- Java 17
- Spring Boot 3.3 (Web, Data JPA, Validation)
- H2 in-memory database (zero setup — swap for MySQL/Postgres later by editing `application.properties`)
- Lombok
- Maven

## Project Structure
```
src/main/java/com/example/payroll/
├── PayrollApplication.java     # entry point
├── entity/                     # Employee, Payroll (JPA entities)
├── repository/                 # Spring Data JPA repositories
├── service/                    # business logic + salary calculation
├── controller/                 # REST endpoints
├── dto/                        # request bodies
└── exception/                  # custom exceptions + global handler
```

## How to Run

1. Make sure you have **Java 17+** and **Maven** installed.
2. From the project root:
   ```bash
   mvn spring-boot:run
   ```
3. The API starts at `http://localhost:8080`.
4. H2 console (to inspect the database in a browser): `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:payrolldb`
   - Username: `sa`, Password: *(blank)*

## Core Concepts (for your mentor review)

- **Employee** stores basic info + `basicSalary`, `hraPercent`, `daPercent`.
- **Payroll** is generated per employee per month/year. The service layer computes:
  - `HRA = basicSalary × hraPercent%`
  - `DA = basicSalary × daPercent%`
  - `Gross = basic + HRA + DA`
  - Deductions: Provident Fund (12% of basic), flat Professional Tax, a simplified Income Tax slab
  - `Net Salary = Gross − Total Deductions`
- A **unique constraint** on `(employee_id, month, year)` stops duplicate payroll runs for the same period.
- **DTOs** (`EmployeeRequest`, `GeneratePayrollRequest`) separate the API contract from the JPA entities.
- **`@RestControllerAdvice`** centralizes error handling (404s, validation errors, duplicates) into consistent JSON responses.

## API Reference

### Employees
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Create employee |
| GET | `/api/employees` | List all (supports `?department=` or `?activeOnly=true`) |
| GET | `/api/employees/{id}` | Get one |
| PUT | `/api/employees/{id}` | Update |
| PATCH | `/api/employees/{id}/deactivate` | Soft-delete (mark inactive) |
| DELETE | `/api/employees/{id}` | Hard delete |

**Create employee example:**
```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Priya Sharma",
    "email": "priya.sharma@example.com",
    "phone": "9876543210",
    "department": "Engineering",
    "designation": "Software Engineer",
    "basicSalary": 60000,
    "hraPercent": 20,
    "daPercent": 10
  }'
```

### Payroll
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/payrolls/employee/{employeeId}/generate` | Generate payroll for a month |
| GET | `/api/payrolls/employee/{employeeId}` | Full payroll history for one employee |
| GET | `/api/payrolls/employee/{employeeId}/payslip?month=8&year=2026` | One payslip |
| GET | `/api/payrolls?month=8&year=2026` | Everyone's payroll for a month |
| PATCH | `/api/payrolls/{payrollId}/mark-paid` | Mark payslip as paid |

**Generate payroll example:**
```bash
curl -X POST http://localhost:8080/api/payrolls/employee/1/generate \
  -H "Content-Type: application/json" \
  -d '{"month": 8, "year": 2026}'
```

## Ideas to Extend (good next steps to show your mentor progress)
- Add Spring Security + JWT for authenticated HR/admin access
- Generate a downloadable PDF payslip
- Add pagination/sorting to the employee list endpoint
- Switch H2 → MySQL/Postgres for persistent storage
- Add attendance/leave tracking that feeds into payroll deductions
