package com.clinic.service;

import com.clinic.config.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentService {

    public boolean completeAppointment(int appointmentId, BigDecimal amount, String diagnosis) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // stop auto-saving after each statement

            // Write 1: mark appointment as completed
            String updateSql = "UPDATE appointments SET status = 'Completed' WHERE appointment_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                pstmt.setInt(1, appointmentId);
                pstmt.executeUpdate();
            }

            // Write 2: create the bill
            String billSql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, 'Pending')";
            try (PreparedStatement pstmt = conn.prepareStatement(billSql)) {
                pstmt.setInt(1, appointmentId);
                pstmt.setBigDecimal(2, amount);
                pstmt.executeUpdate();
            }

            // Write 3: record what happened during the visit
            String visitSql = "INSERT INTO visit_history (appointment_id, diagnosis) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(visitSql)) {
                pstmt.setInt(1, appointmentId);
                pstmt.setString(2, diagnosis);
                pstmt.executeUpdate();
            }

            conn.commit(); // all 3 worked -> save everything for real
            return true;

        } catch (SQLException e) {
            System.out.println("Something failed, undoing everything: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
