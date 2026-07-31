 -- DDL — SCHEMA CREATION

CREATE DATABASE HospitalDB;
USE HospitalDB;

CREATE TABLE Doctors (
    DoctorID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Specialization VARCHAR(50)
);
 
CREATE TABLE Patients (
    PatientID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Age INT,
    MedicalRecord JSON             
);

CREATE TABLE Appointments (
    AppointmentID INT PRIMARY KEY AUTO_INCREMENT,
    PatientID INT,
    DoctorID INT,
    AppointmentDate DATETIME,
    Status VARCHAR(20) DEFAULT 'Scheduled',
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);
 
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    ManagerID INT
);
 
CREATE TABLE TestResults (
    PatientID INT,
    TestName VARCHAR(50),
    Result VARCHAR(50)
);


-- DML — SAMPLE DATA

INSERT INTO Doctors (Name, Specialization) VALUES
('Dr. Mehta', 'Cardiology'),
('Dr. Singh', 'Orthopedics');
 
INSERT INTO Patients (Name, Age) VALUES
('Arjun', 25),
('Priya', 32),
('Ravi', 40);
 
INSERT INTO Appointments (PatientID, DoctorID, AppointmentDate, Status) VALUES
(1, 1, '2026-07-01 10:00:00', 'Completed'),
(2, 1, '2026-07-05 11:00:00', 'Completed'),
(1, 2, '2026-07-10 09:00:00', 'Scheduled'),
(3, 1, '2026-07-12 14:00:00', 'Completed');
 
INSERT INTO Employees (Name, ManagerID) VALUES
('Ravi', NULL),
('Arjun', 1),
('Priya', 1);

-- ALTER / DROP / TRUNCATE examples

ALTER TABLE Patients ADD Phone INT;
DROP TABLE Employees;
TRUNCATE TABLE Appointments;


-- INNER JOIN
SELECT P.Name AS Patient, D.Name AS Doctor, A.AppointmentDate, A.Status
FROM Appointments A
INNER JOIN Patients P ON A.PatientID = P.PatientID
INNER JOIN Doctors D ON A.DoctorID = D.DoctorID;
 
-- LEFT JOIN
SELECT P.Name, A.AppointmentDate
FROM Patients P
LEFT JOIN Appointments A ON P.PatientID = A.PatientID;
 
-- RIGHT JOIN
SELECT P.Name, A.AppointmentDate
FROM Appointments A
RIGHT JOIN Patients P ON P.PatientID = A.PatientID;
 
-- FULL OUTER JOIN (MySQL: emulate with UNION of LEFT + RIGHT)
SELECT P.Name, A.AppointmentDate
FROM Patients P
LEFT JOIN Appointments A ON P.PatientID = A.PatientID
UNION
SELECT P.Name, A.AppointmentDate
FROM Patients P
RIGHT JOIN Appointments A ON P.PatientID = A.PatientID;

-- SELF JOIN
SELECT A.Name AS Employee, B.Name AS Manager
FROM Employees A
JOIN Employees B ON A.ManagerID = B.EmployeeID;