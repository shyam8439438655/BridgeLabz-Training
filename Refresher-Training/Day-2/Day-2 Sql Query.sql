CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;
-- Drop Day 1 basic tables to rebuild normalized version
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS doctors;

-- 1. Patients (3NF compliant)
CREATE TABLE patients (
patient_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
date_of_birth DATE,
gender ENUM('Male', 'Female', 'Other'),
email VARCHAR(100) UNIQUE,
registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- 2. Patient Phones (1NF fix -- multi-valued attribute separated)
CREATE TABLE patient_phones (
phone_id INT AUTO_INCREMENT PRIMARY KEY,
patient_id INT NOT NULL,
phone_number VARCHAR(15) NOT NULL,
FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE,
INDEX idx_patient_id (patient_id)
);
-- 3. Doctors (3NF compliant -- specialization moved out, see below)
CREATE TABLE doctors (
doctor_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(15) UNIQUE,
email VARCHAR(100) UNIQUE
);
-- 4. Specializations (separate entity)
CREATE TABLE specializations (
specialization_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL UNIQUE,
description VARCHAR(255)
);
-- 5. Doctor <-> Specialization (M:N junction table)
CREATE TABLE doctor_specializations (
doctor_id INT,
specialization_id INT,
PRIMARY KEY (doctor_id, specialization_id),
FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ON DELETE CASCADE,
FOREIGN KEY (specialization_id) REFERENCES specializations(specialization_id) ON DELETE
CASCADE
);
-- 6. Appointments (core transactional table)
CREATE TABLE appointments (
appointment_id INT AUTO_INCREMENT PRIMARY KEY,
patient_id INT NOT NULL,
doctor_id INT NOT NULL,
appointment_date DATETIME NOT NULL,
status ENUM('Scheduled', 'Completed', 'Cancelled') DEFAULT 'Scheduled',
FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
INDEX idx_patient_id (patient_id),
INDEX idx_doctor_date (doctor_id, appointment_date) -- composite index
);

-- 7. Billing (1:1 with Appointment)
CREATE TABLE billing (
bill_id INT AUTO_INCREMENT PRIMARY KEY,
appointment_id INT NOT NULL UNIQUE, -- UNIQUE enforces 1:1
amount DECIMAL(10,2) NOT NULL,
payment_status ENUM('Pending', 'Paid', 'Refunded') DEFAULT 'Pending',
billing_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);
-- 8. Visit History (1:1 with Appointment)
CREATE TABLE visit_history (
visit_id INT AUTO_INCREMENT PRIMARY KEY,
appointment_id INT NOT NULL UNIQUE, -- UNIQUE enforces 1:1
diagnosis VARCHAR(255),
prescription VARCHAR(255),
visit_notes TEXT,
FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);
-- Sample Data
INSERT INTO patients (first_name, last_name, date_of_birth, gender, email)
VALUES ('Ramesh', 'Kumar', '1979-05-14', 'Male', 'ramesh@email.com');
INSERT INTO patient_phones (patient_id, phone_number) VALUES (1, '9876543210'), (1, '9998887777');
INSERT INTO doctors (first_name, last_name, phone_number, email)
VALUES ('Anjali', 'Rao', '9123456780', 'dr.rao@clinic.com');
INSERT INTO specializations (name, description)
VALUES ('Cardiology', 'Heart-related treatment'), ('Pediatrics', 'Child healthcare');
INSERT INTO doctor_specializations (doctor_id, specialization_id) VALUES (1, 1);
INSERT INTO appointments (patient_id, doctor_id, appointment_date, status)
VALUES (1, 1, '2026-08-05 10:00:00', 'Scheduled');
INSERT INTO billing (appointment_id, amount, payment_status)
VALUES (1, 1500.00, 'Pending');
INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes)
VALUES (1, 'Routine Checkup', 'None', 'Patient in good health');
-- Verify with a join
SELECT p.first_name, p.last_name, d.first_name AS doctor_name,
a.appointment_date, b.amount, v.diagnosis
FROM appointments a
JOIN patients p ON a.patient_id = p.patient_id
JOIN doctors d ON a.doctor_id = d.doctor_id
JOIN billing b ON a.appointment_id = b.appointment_id
JOIN visit_history v ON a.appointment_id = v.appointment_id;

USE HospitalDB;

-- =========================================================
-- 1. ROOMS TABLE
-- =========================================================

CREATE TABLE IF NOT EXISTS Rooms (
    RoomID INT PRIMARY KEY AUTO_INCREMENT,
    RoomNumber VARCHAR(20) NOT NULL,
    Floor INT
);


-- =========================================================
-- 1. DOCTOR_ROOM RELATIONSHIP
-- =========================================================

CREATE TABLE IF NOT EXISTS Doctor_Room (
    DoctorID INT,
    RoomID INT,
    PRIMARY KEY (DoctorID, RoomID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID),
    FOREIGN KEY (RoomID) REFERENCES Rooms(RoomID)
);


-- Insert rooms only if table is empty
INSERT INTO Rooms (RoomNumber, Floor)
SELECT 'R101', 1
WHERE NOT EXISTS (SELECT 1 FROM Rooms WHERE RoomNumber = 'R101');

INSERT INTO Rooms (RoomNumber, Floor)
SELECT 'R102', 1
WHERE NOT EXISTS (SELECT 1 FROM Rooms WHERE RoomNumber = 'R102');

INSERT INTO Rooms (RoomNumber, Floor)
SELECT 'R201', 2
WHERE NOT EXISTS (SELECT 1 FROM Rooms WHERE RoomNumber = 'R201');


-- Assign existing doctors to existing rooms
-- This automatically takes actual DoctorIDs from Doctors table

INSERT IGNORE INTO Doctor_Room (DoctorID, RoomID)
SELECT d.DoctorID, r.RoomID
FROM 
    (SELECT DoctorID FROM Doctors ORDER BY DoctorID LIMIT 3) d
CROSS JOIN
    (SELECT RoomID FROM Rooms ORDER BY RoomID LIMIT 3) r
WHERE d.DoctorID = (
    SELECT DoctorID FROM Doctors ORDER BY DoctorID LIMIT 1
)
OR d.DoctorID = (
    SELECT DoctorID FROM Doctors ORDER BY DoctorID LIMIT 1 OFFSET 1
)
OR d.DoctorID = (
    SELECT DoctorID FROM Doctors ORDER BY DoctorID LIMIT 1 OFFSET 2
)
LIMIT 3;


-- Check Doctor-Room relationship

SELECT 
    d.DoctorID,
    d.Name AS DoctorName,
    r.RoomID,
    r.RoomNumber,
    r.Floor
FROM Doctor_Room dr
JOIN Doctors d 
    ON dr.DoctorID = d.DoctorID
JOIN Rooms r 
    ON dr.RoomID = r.RoomID;


-- =========================================================
-- 2. EXPLAIN WITHOUT INDEX
-- =========================================================

EXPLAIN
SELECT *
FROM Appointments
WHERE Status = 'Scheduled';


-- =========================================================
-- 2. SINGLE-COLUMN INDEX
-- =========================================================

CREATE INDEX IF NOT EXISTS idx_appointments_status
ON Appointments(Status);


-- EXPLAIN USING SINGLE-COLUMN INDEX

EXPLAIN
SELECT *
FROM Appointments
WHERE Status = 'Scheduled';


-- =========================================================
-- 2. COMPOSITE INDEX
-- =========================================================

CREATE INDEX IF NOT EXISTS idx_appointments_doctor_date
ON Appointments(DoctorID, AppointmentDate);


-- EXPLAIN USING COMPOSITE INDEX

EXPLAIN
SELECT *
FROM Appointments
WHERE DoctorID = 1
AND AppointmentDate = '2026-08-03';


-- =========================================================
-- 3. PATIENT_PHONES TABLE
-- =========================================================

CREATE TABLE IF NOT EXISTS patient_phones (
    PatientID INT,
    PhoneNumber VARCHAR(20),
    PhoneType VARCHAR(20),
    PRIMARY KEY (PatientID, PhoneNumber),
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID)
);


-- =========================================================
-- 4. COVERING INDEX
-- =========================================================

CREATE INDEX idx_covering_appointments
ON Appointments(DoctorID, AppointmentDate, Status);


-- EXPLAIN COVERING INDEX

EXPLAIN
SELECT DoctorID, AppointmentDate, Status
FROM Appointments;