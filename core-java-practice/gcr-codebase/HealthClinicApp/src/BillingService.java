import java.sql.*;

public class BillingService {

    public static void generateBill(int visitId, double amount) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO bills(visit_id,amount,payment_status) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, visitId);
            ps.setDouble(2, amount);
            ps.setString(3, "UNPAID");
            ps.executeUpdate();
            System.out.println("Bill generated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
