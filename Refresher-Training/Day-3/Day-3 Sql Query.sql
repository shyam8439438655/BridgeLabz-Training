
DROP DATABASE IF EXISTS health_clinic;
CREATE DATABASE health_clinic;
USE health_clinic;

-- ================= TABLES =================

CREATE TABLE Specializations (
    specialization_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE Patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    dob DATE,
    gender VARCHAR(20),
    phone VARCHAR(15),
    address VARCHAR(255)
);

CREATE TABLE Doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    specialization_id INT,
    mentor_id INT,
    FOREIGN KEY (specialization_id)
        REFERENCES Specializations(specialization_id),
    FOREIGN KEY (mentor_id)
        REFERENCES Doctors(doctor_id)
);

CREATE TABLE Appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    status VARCHAR(30) DEFAULT 'Scheduled',
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id)
);

CREATE TABLE VisitHistory (
    visit_id INT PRIMARY KEY AUTO_INCREMENT,
    appointment_id INT NOT NULL,
    notes VARCHAR(500),
    visit_date DATETIME,
    FOREIGN KEY (appointment_id) REFERENCES Appointments(appointment_id)
);

CREATE TABLE Billing (
    bill_id INT PRIMARY KEY AUTO_INCREMENT,
    appointment_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_status VARCHAR(30) DEFAULT 'Pending',
    bill_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (appointment_id) REFERENCES Appointments(appointment_id)
);

CREATE TABLE AuditLog (
    audit_id INT PRIMARY KEY AUTO_INCREMENT,
    action VARCHAR(30),
    table_name VARCHAR(100),
    record_id INT,
    action_time DATETIME
);

CREATE TABLE DeletedPatientsArchive (
    archive_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    name VARCHAR(100),
    deleted_at DATETIME
);

CREATE TABLE TimeSlots (
    slot_id INT PRIMARY KEY AUTO_INCREMENT,
    slot_time TIME NOT NULL
);

-- ================= SAMPLE DATA =================

INSERT INTO Specializations (name) VALUES
('Cardiology'), ('Neurology'), ('Dermatology'),
('Orthopedics'), ('General Medicine');

INSERT INTO Patients (name,dob,gender,phone,address) VALUES
('Rahul Sharma','1995-05-10','Male','9876543210','Agra'),
('Priya Singh','1998-08-15','Female','9876543211','Mathura'),
('Amit Kumar','1990-03-20','Male','9876543212','Delhi'),
('Neha Verma','2000-12-01','Female','9876543213','Agra'),
('Ravi Kumar','1992-07-25','Male','9876543214','Jaipur'),
('Pooja Gupta','1997-04-18','Female','9876543215','Lucknow');

INSERT INTO Doctors (name,phone,specialization_id,mentor_id) VALUES
('Dr. Amit Gupta','9000000001',1,NULL),
('Dr. Neha Sharma','9000000002',2,1),
('Dr. Raj Verma','9000000003',3,1),
('Dr. Pooja Singh','9000000004',4,2),
('Dr. Suresh Kumar','9000000005',5,1);

INSERT INTO Appointments
(patient_id,doctor_id,appointment_date,status) VALUES
(1,1,'2026-08-10 10:00:00','Scheduled'),
(2,2,'2026-08-11 11:00:00','Confirmed'),
(3,3,'2026-08-12 12:00:00','Completed'),
(1,2,'2026-08-13 14:00:00','Confirmed'),
(4,4,'2026-08-14 15:00:00','Scheduled');

INSERT INTO VisitHistory
(appointment_id,notes,visit_date) VALUES
(3,'Patient consultation completed','2026-08-12 13:00:00');

INSERT INTO Billing
(appointment_id,amount,payment_status,bill_date) VALUES
(1,1000,'Pending','2026-08-10'),
(2,1500,'Paid','2026-08-11'),
(3,2000,'Paid','2026-08-12');

INSERT INTO TimeSlots (slot_time) VALUES
('09:00:00'),('10:00:00'),('11:00:00'),('12:00:00');

-- ================= SQL JOINS =================

-- 1. INNER JOIN
SELECT p.name AS patient_name,a.appointment_date
FROM Patients p
INNER JOIN Appointments a
ON p.patient_id=a.patient_id;

-- 2. INNER JOIN WITH THREE TABLES
SELECT p.name AS patient,d.name AS doctor,a.status
FROM Appointments a
INNER JOIN Patients p ON a.patient_id=p.patient_id
INNER JOIN Doctors d ON a.doctor_id=d.doctor_id;

-- 3. LEFT JOIN
SELECT p.name,a.appointment_date
FROM Patients p
LEFT JOIN Appointments a
ON p.patient_id=a.patient_id;

-- 4. LEFT JOIN - PATIENTS WITHOUT APPOINTMENTS
SELECT p.name
FROM Patients p
LEFT JOIN Appointments a
ON p.patient_id=a.patient_id
WHERE a.appointment_id IS NULL;

-- 5. RIGHT JOIN
SELECT d.name AS doctor,a.appointment_date
FROM Appointments a
RIGHT JOIN Doctors d
ON a.doctor_id=d.doctor_id;

-- 6. FULL OUTER JOIN SIMULATION
SELECT p.name,a.appointment_id
FROM Patients p
LEFT JOIN Appointments a
ON p.patient_id=a.patient_id
UNION
SELECT p.name,a.appointment_id
FROM Patients p
RIGHT JOIN Appointments a
ON p.patient_id=a.patient_id;

-- 7. SELF JOIN
SELECT d.name AS doctor,m.name AS mentor
FROM Doctors d
LEFT JOIN Doctors m
ON d.mentor_id=m.doctor_id;

-- 8. CROSS JOIN
SELECT d.name,t.slot_time
FROM Doctors d
CROSS JOIN TimeSlots t;

-- 9. MULTIPLE TABLE JOIN
SELECT p.name AS patient,
       d.name AS doctor,
       s.name AS specialization,
       a.appointment_date
FROM Appointments a
JOIN Patients p ON a.patient_id=p.patient_id
JOIN Doctors d ON a.doctor_id=d.doctor_id
JOIN Specializations s
ON d.specialization_id=s.specialization_id;

-- 10. MULTIPLE TABLE JOIN WITH BILLING
SELECT p.name AS patient,
       d.name AS doctor,
       s.name AS specialization,
       a.status,
       b.amount,
       b.payment_status
FROM Appointments a
JOIN Patients p ON a.patient_id=p.patient_id
JOIN Doctors d ON a.doctor_id=d.doctor_id
JOIN Specializations s
ON d.specialization_id=s.specialization_id
LEFT JOIN Billing b
ON a.appointment_id=b.appointment_id;

-- ================= STORED PROCEDURES =================

-- 11. SIMPLE PROCEDURE
DROP PROCEDURE IF EXISTS GetAllPatients;
DELIMITER //

CREATE PROCEDURE GetAllPatients()
BEGIN
    SELECT * FROM Patients;
END //

DELIMITER ;

CALL GetAllPatients();

-- 12. IN PARAMETER
DROP PROCEDURE IF EXISTS GetPatientAppointments;
DELIMITER //

CREATE PROCEDURE GetPatientAppointments(IN p_id INT)
BEGIN
    SELECT a.appointment_id,
           a.appointment_date,
           a.status,
           d.name AS doctor
    FROM Appointments a
    JOIN Doctors d ON a.doctor_id=d.doctor_id
    WHERE a.patient_id=p_id;
END //

DELIMITER ;

CALL GetPatientAppointments(1);

-- 13. IN PARAMETER - INSERT
DROP PROCEDURE IF EXISTS AddPatient;
DELIMITER //

CREATE PROCEDURE AddPatient(
    IN p_name VARCHAR(100),
    IN p_phone VARCHAR(15)
)
BEGIN
    INSERT INTO Patients(name,phone)
    VALUES(p_name,p_phone);
END //

DELIMITER ;

CALL AddPatient('Suresh Kumar','9999999999');

-- 14. OUT PARAMETER
DROP PROCEDURE IF EXISTS GetPatientCount;
DELIMITER //

CREATE PROCEDURE GetPatientCount(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total
    FROM Patients;
END //

DELIMITER ;

CALL GetPatientCount(@total);
SELECT @total AS total_patients;

-- 15. INOUT PARAMETER
DROP PROCEDURE IF EXISTS ApplyDiscount;
DELIMITER //

CREATE PROCEDURE ApplyDiscount(INOUT amount DECIMAL(10,2))
BEGIN
    SET amount=amount-(amount*0.10);
END //

DELIMITER ;

SET @bill=1000;
CALL ApplyDiscount(@bill);
SELECT @bill AS discounted_amount;

-- 16. ERROR HANDLING
DROP PROCEDURE IF EXISTS SafeAddPatient;
DELIMITER //

CREATE PROCEDURE SafeAddPatient(
    IN p_name VARCHAR(100),
    IN p_phone VARCHAR(15)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Operation Failed' AS message;
    END;

    START TRANSACTION;

    INSERT INTO Patients(name,phone)
    VALUES(p_name,p_phone);

    COMMIT;
    SELECT 'Patient Added Successfully' AS message;
END //

DELIMITER ;

CALL SafeAddPatient('Test Patient','8888888888');

-- 17. APPOINTMENT PROCEDURE
DROP PROCEDURE IF EXISTS BookAppointment;
DELIMITER //

CREATE PROCEDURE BookAppointment(
    IN p_patient INT,
    IN p_doctor INT,
    IN p_date DATETIME
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Booking Failed' AS message;
    END;

    START TRANSACTION;

    INSERT INTO Appointments
    (patient_id,doctor_id,appointment_date,status)
    VALUES(p_patient,p_doctor,p_date,'Confirmed');

    COMMIT;
    SELECT 'Appointment Booked Successfully' AS message;
END //

DELIMITER ;

CALL BookAppointment(1,3,'2026-08-20 10:00:00');

-- 18. BILLING PROCEDURE WITH OUT
DROP PROCEDURE IF EXISTS GenerateBill;
DELIMITER //

CREATE PROCEDURE GenerateBill(
    IN p_appointment INT,
    IN p_amount DECIMAL(10,2),
    OUT p_bill_id INT
)
BEGIN
    INSERT INTO Billing
    (appointment_id,amount,payment_status)
    VALUES(p_appointment,p_amount,'Pending');

    SET p_bill_id=LAST_INSERT_ID();
END //

DELIMITER ;

CALL GenerateBill(1,2500,@new_bill);
SELECT @new_bill AS generated_bill;

-- ================= TRIGGERS =================

-- 19. BEFORE INSERT
DROP TRIGGER IF EXISTS before_appointment_insert;
DELIMITER //

CREATE TRIGGER before_appointment_insert
BEFORE INSERT ON Appointments
FOR EACH ROW
BEGIN
    IF NEW.appointment_date<NOW() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT='Cannot book past appointment';
    END IF;
END //

DELIMITER ;

-- 20. AFTER INSERT
DROP TRIGGER IF EXISTS after_appointment_insert;
DELIMITER //

CREATE TRIGGER after_appointment_insert
AFTER INSERT ON Appointments
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog
    (action,table_name,record_id,action_time)
    VALUES('INSERT','Appointments',NEW.appointment_id,NOW());
END //

DELIMITER ;

-- 21. BEFORE UPDATE
DROP TRIGGER IF EXISTS before_billing_update;
DELIMITER //

CREATE TRIGGER before_billing_update
BEFORE UPDATE ON Billing
FOR EACH ROW
BEGIN
    IF NEW.payment_status='Paid'
       AND OLD.payment_status<>'Paid' THEN
        SET NEW.bill_date=NOW();
    END IF;
END //

DELIMITER ;

-- 22. AFTER UPDATE
DROP TRIGGER IF EXISTS after_appointment_update;
DELIMITER //

CREATE TRIGGER after_appointment_update
AFTER UPDATE ON Appointments
FOR EACH ROW
BEGIN
    IF NEW.status='Completed'
       AND OLD.status<>'Completed' THEN
        INSERT INTO VisitHistory
        (appointment_id,notes,visit_date)
        VALUES
        (NEW.appointment_id,
        'Appointment completed',
        NOW());
    END IF;
END //

DELIMITER ;

-- 23. BEFORE DELETE
DROP TRIGGER IF EXISTS before_patient_delete;
DELIMITER //

CREATE TRIGGER before_patient_delete
BEFORE DELETE ON Patients
FOR EACH ROW
BEGIN
    IF EXISTS(
        SELECT 1 FROM Appointments
        WHERE patient_id=OLD.patient_id
        AND status='Confirmed'
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT=
        'Cannot delete patient with active appointment';
    END IF;
END //

DELIMITER ;

-- 24. AFTER DELETE
DROP TRIGGER IF EXISTS after_patient_delete;
DELIMITER //

CREATE TRIGGER after_patient_delete
AFTER DELETE ON Patients
FOR EACH ROW
BEGIN
    INSERT INTO DeletedPatientsArchive
    (patient_id,name,deleted_at)
    VALUES(OLD.patient_id,OLD.name,NOW());
END //

DELIMITER ;

-- ================= TRIGGER TESTING =================

-- AFTER INSERT TEST
INSERT INTO Appointments
(patient_id,doctor_id,appointment_date,status)
VALUES(5,5,'2026-08-25 10:00:00','Scheduled');

SELECT * FROM AuditLog;

-- AFTER UPDATE TEST
UPDATE Appointments
SET status='Completed'
WHERE appointment_id=1;

SELECT * FROM VisitHistory;

-- BEFORE UPDATE TEST
UPDATE Billing
SET payment_status='Paid'
WHERE bill_id=1;

SELECT * FROM Billing;

-- BEFORE DELETE + AFTER DELETE TEST
-- Patient 6 has no appointment, so deletion is allowed
DELETE FROM Patients
WHERE patient_id=6;

SELECT * FROM DeletedPatientsArchive;

-- ================= FINAL REPORT =================

SELECT
    a.appointment_id,
    p.name AS patient,
    d.name AS doctor,
    s.name AS specialization,
    a.appointment_date,
    a.status,
    b.amount,
    b.payment_status
FROM Appointments a
JOIN Patients p ON a.patient_id=p.patient_id
JOIN Doctors d ON a.doctor_id=d.doctor_id
JOIN Specializations s
ON d.specialization_id=s.specialization_id
LEFT JOIN Billing b
ON a.appointment_id=b.appointment_id;
