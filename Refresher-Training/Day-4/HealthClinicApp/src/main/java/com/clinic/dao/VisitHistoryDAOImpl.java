package com.clinic.dao;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.VisitHistory;

import java.sql.*;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public int insertVisitHistory(VisitHistory visitHistory) {
        String sql = "INSERT INTO visit_history (appointment_id, diagnosis) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setInt(1, visitHistory.getAppointmentId());
            pstmt.setString(2, visitHistory.getDiagnosis());
            // visit_date defaults to CURRENT_TIMESTAMP, so we can omit it in insert
            pstmt.executeUpdate();
            
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public VisitHistory getVisitHistoryById(int id) {
        String sql = "SELECT * FROM visit_history WHERE history_id = ?";
        return getHistoryByQuery(sql, id);
    }

    @Override
    public VisitHistory getVisitHistoryByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM visit_history WHERE appointment_id = ?";
        return getHistoryByQuery(sql, appointmentId);
    }
    
    private VisitHistory getHistoryByQuery(String sql, int param) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, param);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                VisitHistory v = new VisitHistory();
                v.setHistoryId(rs.getInt("history_id"));
                v.setAppointmentId(rs.getInt("appointment_id"));
                v.setDiagnosis(rs.getString("diagnosis"));
                v.setVisitDate(rs.getTimestamp("visit_date").toLocalDateTime());
                return v;
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return null;
    }
}
