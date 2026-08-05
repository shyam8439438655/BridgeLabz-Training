package com.clinic.dao;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.Billing;

import java.sql.*;

public class BillingDAOImpl implements BillingDAO {

    @Override
    public int insertBilling(Billing billing) {
        String sql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setInt(1, billing.getAppointmentId());
            pstmt.setBigDecimal(2, billing.getAmount());
            pstmt.setString(3, billing.getPaymentStatus());
            pstmt.executeUpdate();
            
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Billing getBillingById(int id) {
        String sql = "SELECT * FROM billing WHERE bill_id = ?";
        return getBillingByQuery(sql, id);
    }

    @Override
    public Billing getBillingByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM billing WHERE appointment_id = ?";
        return getBillingByQuery(sql, appointmentId);
    }
    
    private Billing getBillingByQuery(String sql, int param) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, param);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Billing b = new Billing();
                b.setBillId(rs.getInt("bill_id"));
                b.setAppointmentId(rs.getInt("appointment_id"));
                b.setAmount(rs.getBigDecimal("amount"));
                b.setPaymentStatus(rs.getString("payment_status"));
                return b;
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return null;
    }
}
