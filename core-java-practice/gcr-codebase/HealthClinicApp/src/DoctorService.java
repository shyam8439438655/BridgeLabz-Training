import java.sql.*;

public class DoctorService {
    public static void addDoctor(String name, int specialtyId, String contact, double fee) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO doctors(name,specialty_id,contact,fee) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, specialtyId);
            ps.setString(3, contact);
            ps.setDouble(4, fee);
            ps.executeUpdate();
            System.out.println("Doctor added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
