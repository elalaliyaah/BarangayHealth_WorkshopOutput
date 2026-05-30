package com.example.barangay_health.repository;

import com.example.barangay_health.model.Patient;
import com.example.barangay_health.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {

    public List<Patient> findAll() throws SQLException {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT id, patient_name, department, concern, date FROM patients ORDER BY created_at DESC";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Patient(
                        rs.getInt("id"),
                        rs.getString("patient_name"),
                        rs.getString("department"),
                        rs.getString("concern"),
                        rs.getString("date")
                ));
            }
        }
        return list;
    }

    public int countByDepartment(String department) throws SQLException {
        String sql = "SELECT COUNT(*) FROM patients WHERE department = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, department);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return 0;
    }

    public void save(String patientName, String department, String concern, String date) throws SQLException {
        String sql = "INSERT INTO patients (patient_name, department, concern, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patientName);
            stmt.setString(2, department);
            stmt.setString(3, concern);
            stmt.setDate(4, Date.valueOf(date));
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
