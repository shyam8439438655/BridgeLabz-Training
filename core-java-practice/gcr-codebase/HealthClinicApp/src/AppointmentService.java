import java.sql.*;

public class AppointmentService {

    public static void bookAppointment(int patientId, int doctorId, String date, String time) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setString(3, date);
            ps.setString(4, time);
            ps.setString(5, "SCHEDULED");
            ps.executeUpdate();
            System.out.println("Appointment booked successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
