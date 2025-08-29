package managementschool.service;

import managementschool.entity.Teacher;
import java.sql.*;

public class TeacherService {
    public void save(Teacher teacher) {
        String sql = "INSERT INTO teacher(id, name, subject) VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, teacher.getId());
            ps.setString(2, teacher.getName());
            ps.setString(3, teacher.getSubject());
            ps.executeUpdate();
            System.out.println("Teacher saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllTeachers() {
        String sql = "SELECT * FROM teacher";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("subject"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
