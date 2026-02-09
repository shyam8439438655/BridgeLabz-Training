import java.sql.*;

public class PatientService {

    public static void registerPatient(String name, String dob, String phone,
                                       String address, String bloodGroup) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO patients(name,dob,phone,address,blood_group) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, bloodGroup);
            ps.executeUpdate();
            System.out.println("Patient registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewVisitHistory(int patientId) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT v.visit_date, v.diagnosis FROM visits v " +
                         "JOIN appointments a ON v.appointment_id=a.appointment_id " +
                         "WHERE a.patient_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getDate("visit_date") + " - " +
                                   rs.getString("diagnosis"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
