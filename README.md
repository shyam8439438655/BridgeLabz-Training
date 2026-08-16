# Refresher Training

________________________________________________________________________________________________________________

📚 Overview

This repository contains the learning materials, SQL scripts, and practical exercises covered during the **Database Programming Refresher Training**. The training focuses on DBMS fundamentals, RDBMS concepts, SQL, ER diagrams, indexing, and database normalization.

________________________________________________________________________________________________________________

```
Database-Programming/
│
├── Day-1/
│   ├── DBMS-Fundamentals/
│   ├── RDBMS-Basics/
│   ├── DDL/
│   ├── DML/
│   └── SQL-Scripts/
│
├── Day-2/
│   ├── ER-Diagram/
│   ├── Indexing/
│   ├── Normalization/
│   └── SQL-Scripts/
│
├── Day-3/
│   ├── SQL-Joins/
│   ├── Stored-Procedures/
│   ├── Triggers/
│   └── SQL-Scripts/
│
├── Day-4/
│   ├── JDBC/
│   ├── CRUD-Operations/
│   ├── Transaction-Management/
│   ├── Connection-Pooling/
│   └── Health-Clinic-Management-System/
│       ├── Database-Schema/
│       ├── Java-Code/
│       └── SQL-Scripts/
├── Day-5/
│   ├── Java-Servlets/
│   ├── Servlet-Project/
│   ├── Apache-Tomcat-Configuration/
│   ├── Servlet-Lifecycle/
│   ├── HTTP-Request-Response/
│   ├── URL-Mapping/
│   └── Maven-Dependency-Management/
│
├── Day-6/
│
│   ├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/bridgelabz/greetingsApp/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── entity/
│   │   │       └── GreetingsAppApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
├── pom.xml
│
├── Day-7/
│
│   └── ContactApp/
│       │
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   │   └── com/contactApp/contactApp/
│       │   │   │       ├── controller/
│       │   │   │       ├── service/
│       │   │   │       ├── repository/
│       │   │   │       ├── entity/
│       │   │   │       ├── dto/
│       │   │   │       ├── exception/
│       │   │   │       └── ContactAppApplication.java
│       │   │   │
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   │
│       │   └── test/
│       │
│       ├── pom.xml
│
├── Day-8/
│
│   └── College-Management/
│       │
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   │   └── com/bridgelabz/collegeManagement/
│       │   │   │       ├── controller/
│       │   │   │       ├── service/
│       │   │   │       ├── repository/
│       │   │   │       ├── entity/
│       │   │   │       ├── dto/
│       │   │   │       ├── annotation/
│       │   │   │       ├── validator/
│       │   │   │       └── CollegeManagementApplication.java
│       │   │   │
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   │
│       │   └── test/
│       │
│       ├── pom.xml
├── Day-9/
│   ├── Spring-Boot-Advanced/
│   ├── REST-API/
│   ├── Validation/
│   ├── Exception-Handling/
│   ├── Spring-Data-JPA/
│   ├── H2-Database/
│   ├── Postman-API-Testing/
│   └── Project/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       │
│       └── pom.xml
├── Day-10/
│   ├── Spring-Boot-Advanced/
│   ├── REST-API/
│   ├── Validation/
│   ├── Exception-Handling/
│   ├── DTO-and-Mapper/
│   ├── Spring-Data-JPA/
│   ├── H2-Database/
│   ├── Postman-API-Testing/
│   └── Project/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       │
│       └── pom.xml
|
├── Day-11/
│   └── Payroll-App/
│       │
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   │   └── com/example/payroll/
│       │   │   │       ├── controller/
│       │   │   │       ├── service/
│       │   │   │       ├── repository/
│       │   │   │       ├── entity/
│       │   │   │       ├── dto/
│       │   │   │       ├── exception/
│       │   │   │       └── PayrollApplication.java
│       │   │   │
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   │
│       │   └── test/
│       │
│       ├── pom.xml
│       └── README.md
└── README.md
```

## 📅 Day 1 – DBMS Fundamentals & RDBMS Basics  (31/07/26)

```
### 🎯 Topic Covered
**DBMS Fundamentals & RDBMS Basics**

### 📖 Content Covered

- Introduction to Database Management Systems (DBMS)
- Different Types of DBMS
  - Relational Database Management System (RDBMS)
  - Non-Relational Database / NoSQL
- Comparison between Relational and Non-Relational Databases
- When to use Relational vs Non-Relational Databases
- Introduction to MySQL
- RDBMS Concepts
- SQL Fundamentals
- DDL – Data Definition Language
- DML – Data Manipulation Language

### 🛠️ Practical Work

- Creating a Database
- Creating Tables using DDL commands
- Modifying Database Structures
- Inserting Data using DML commands
- Updating Existing Records
- Deleting Records
- Executing Basic SQL Queries
```

📅 Day 2 – ER Diagram, Indexing & Normalization (03/08/26)

```
🎯 Topic Covered

ER Diagram, Indexing & Normalization

📖 Content Covered
Introduction to Entity Relationship (ER) Diagrams
ER Diagram Design Principles
Entities
Attributes
Relationships
Cardinality
Designing Database Structures using ER Diagrams
Introduction to Database Indexing
Purpose of Indexes
How Indexing Improves Query Performance
Performance Impact of Indexing
Database Normalization
Normalization Forms:
1NF – First Normal Form
2NF – Second Normal Form
3NF – Third Normal Form
BCNF – Boyce-Codd Normal Form
🛠️ Practical Work
Designing ER Diagrams
Identifying Entities and Relationships
Defining Cardinality between Entities
Creating Tables based on ER Diagrams
Understanding Index Creation
Analyzing Query Performance with Indexes
Applying Normalization Rules to Database Tables
```

📅 Day 3 – SQL Joins, Stored Procedures & Triggers (04/08/26)

```
🎯 Topic Covered

SQL Joins, Stored Procedures & Triggers

📖 Content Covered

SQL Joins
INNER JOIN
LEFT JOIN
RIGHT JOIN
FULL OUTER JOIN
SELF JOIN
CROSS JOIN
Multiple Table JOIN
Stored Procedures
Why Stored Procedures
Creating Procedures
Calling Procedures
IN Parameter
OUT Parameter
INOUT Parameter
Error Handling
Triggers
BEFORE INSERT
AFTER INSERT
BEFORE UPDATE
AFTER UPDATE
BEFORE DELETE
AFTER DELETE

🛠️ Practical Work

Writing SQL queries using different types of JOINs
Combining data from multiple related tables
Creating and calling Stored Procedures
Working with IN, OUT and INOUT parameters
Implementing Error Handling in Stored Procedures
Creating BEFORE and AFTER Triggers
Using Triggers for data validation and business rules
Creating Audit Triggers for tracking database changes
Maintaining Visit History using Triggers
Working with the Health Clinic Database Schema
```

```
📅 Day 4: Health Clinic Management System (JDBC + MySQL) (05/08/26)

### Project Overview
In Day 4, I developed a Health Clinic Management System using Java JDBC and MySQL. T
he main purpose of this project is to manage clinic-related data like patients, doctors,
appointments, rooms, and medical records.

### Technologies Used
- Java
- JDBC (Java Database Connectivity)
- MySQL Database
- MySQL Workbench
- Git & GitHub

### Database Implementation
Created a relational database named `health_clinic_db` with multiple tables:

- Patients
- Doctors
- Appointments
- Rooms
- Doctor_Room
- Patient Phones
- Medical Records

Implemented relationships between tables using:
- Primary Keys
- Foreign Keys
- Constraints

### JDBC Concepts Implemented
- Database connection using JDBC
- Driver loading
- Connection URL configuration
- CRUD Operations:
  - Create
  - Read
  - Update
  - Delete

### SQL Concepts Covered
- Joins
- Stored Procedures
- Triggers
- Indexing
- Query Optimization using EXPLAIN
- Normalization (1NF, 2NF, 3NF)

### Key Learnings
- How Java application connects with MySQL database using JDBC.
- How to execute SQL queries from Java code.
- How database design improves performance and data consistency.
- Understanding of transactions and database relationships.

### Project Status
Completed successfully with database creation, JDBC connectivity, and SQL operations.
```

```
📅 Day 5 - Java Servlet  (06/08/26)
Overview
Learned the fundamentals of Java Servlets and developed a simple web application using Apache Tomcat.

Topics Covered
Introduction to Java Servlets
Creating a Servlet Project using Maven
Configuring Apache Tomcat Server
Adding Servlet API dependency in Maven (pom.xml)
Creating and Running the First Servlet
Understanding Servlet URL Mapping
Web Container Architecture
Web Application Directory Structure
Working with HTML, JSP, and Servlets
Handling HTTP Requests and Responses

### Key Learnings

 - Servlet Lifecycle
 - HttpServlet
 - doGet() and doPost()
 - HttpServletRequest
 - HttpServletResponse
 - @WebServlet Annotation
 - URL Mapping
 - Web Container
 - Maven Dependency Management
```

📅 Day 6  Greetings App  (07/08/26)

```
# Greetings App

## Overview

Greetings App is a Spring Boot REST API application that provides CRUD operations for managing greeting messages.

The application follows a layered architecture:

Controller → Service → Repository → Database


## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
```

```
📅 Day 7 Contact App  (10/08/26)

## Overview

Contact App is a Spring Boot REST API application used to manage contact details.

The application provides CRUD operations for creating, retrieving, updating, and deleting contact information.

The application follows a layered architecture:

Controller → Service → Repository → Database

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

## Features Implemented

- Add new contact
- Get all contacts
- Get contact by ID
- Update contact details
- Delete contact
- Custom exception handling
- DTO based request and response handling

## Project Structure
```



📅 Day 8 College Management App (11/08/26)

```
## Overview

College Management App is a Spring Boot REST API application used to manage student and faculty information.

The application provides CRUD operations for managing students and faculty details.

The application follows a layered architecture:

Controller → Service → Repository → Database

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL / H2 Database
- Maven
- Validation API

## Features Implemented

- Student management
- Faculty management
- Create, Read, Update, Delete operations
- Entity and Repository mapping
- Custom validation using annotations
- Exception handling
- Database integration using JPA

## Project Structure
```
```
# 📅 Day 9 Contact App (12/08/26)

## Overview

Contact App is a Spring Boot REST API application used to manage contact details.

The application provides CRUD operations for creating, retrieving, updating, and deleting contact information.

The application follows a layered architecture:

Controller → Service → Repository → Database

## Technologies Used

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* Lombok
* Jakarta Validation

## Features Implemented

* Add new contact
* Get all contacts
* Get contact by ID
* Search contact by name
* Find contact by mobile number
* Update contact details
* Delete contact
* DTO based request and response handling
* Request validation
* Custom exception handling
* Global exception handling

## Project Structure

* **Controller** – Handles HTTP requests and responses.
* **Service** – Contains the business logic.
* **Repository** – Performs database operations using JPA.
* **Entity** – Represents contact data in the database.
* **DTO** – Handles request and response data.
* **Exception** – Handles custom and global exceptions.
```

```
# 📅 Day 10 Contact App (13/08/26)

## Overview

Contact App is a Spring Boot REST API application used to manage contact details.

The application provides CRUD operations for creating, retrieving, updating, and deleting contact information.

The application follows a layered architecture:

Controller → Service → Mapper → Repository → Database

## Technologies Used

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* Lombok
* Jakarta Validation

## Features Implemented

* Add new contact
* Get all contacts
* Get contact by ID
* Search contact by name
* Find contact by mobile number
* Update contact details
* Delete contact
* DTO based request and response handling
* Mapper for converting DTO and Entity
* Request validation
* Custom exception handling
* Global exception handling

## Project Structure

* **Controller** – Handles HTTP requests and responses.
* **Service** – Contains the business logic.
* **Repository** – Performs database operations using JPA.
* **Entity** – Represents contact data in the database.
* **DTO** – Handles request and response data.
* **Mapper** – Converts RequestDTO to Entity and Entity to ResponseDTO.
* **Exception** – Handles custom and global exceptions.
* **H2 Database** – Stores contact information.
```

```
📅 Day 11 Payroll App (14/08/26)
Overview

Payroll App is a Spring Boot REST API application used to manage employee details and generate payroll information.

The application provides APIs for adding employees, retrieving employee details, updating employee information, and generating payroll records.

The application follows a layered architecture:

Controller → Service → Repository → Database

Technologies Used
Java
Spring Boot
Spring Web
Spring Data JPA
Hibernate
H2 Database
Maven
Lombok
Jakarta Validation
Features Implemented
Add new employee
Get employee details
Update employee details
Delete employee
Generate payroll
Store payroll information
DTO based request handling
Request validation
Custom exception handling
Global exception handling
Database operations using Spring Data JPA
Project Structure
Controller – Handles HTTP requests and responses.
Service – Contains the business logic for employees and payroll.
Repository – Performs database operations using Spring Data JPA.
Entity – Represents employee and payroll data in the database.
DTO – Handles request data received from the client.
Exception – Handles custom exceptions and provides common error responses.
H2 Database – Stores employee and payroll information.
```
