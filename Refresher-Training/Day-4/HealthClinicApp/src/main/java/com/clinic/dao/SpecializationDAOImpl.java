package com.clinic.dao;

import com.clinic.config.DatabaseConnection;
import com.clinic.dto.Specialization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecializationDAOImpl implements SpecializationDAO {

    @Override
    public int insertSpecialization(Specialization specialization) {
        String sql = "INSERT INTO specializations (name) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, specialization.getName());
            pstmt.executeUpdate();
            
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Specialization getSpecializationById(int id) {
        String sql = "SELECT * FROM specializations WHERE specialization_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Specialization s = new Specialization();
                s.setSpecializationId(rs.getInt("specialization_id"));
                s.setName(rs.getString("name"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Specialization> getAllSpecializations() {
        List<Specialization> specializations = new ArrayList<>();
        String sql = "SELECT * FROM specializations";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Specialization s = new Specialization();
                s.setSpecializationId(rs.getInt("specialization_id"));
                s.setName(rs.getString("name"));
                specializations.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return specializations;
    }

    @Override
    public boolean updateSpecialization(Specialization specialization) {
        String sql = "UPDATE specializations SET name = ? WHERE specialization_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, specialization.getName());
            pstmt.setInt(2, specialization.getSpecializationId());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteSpecialization(int id) {
        String sql = "DELETE FROM specializations WHERE specialization_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
        return false;
    }
}
