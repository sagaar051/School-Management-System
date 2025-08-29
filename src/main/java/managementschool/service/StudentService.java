package managementschool.service;

import managementschool.entity.Student;
import java.sql.*;

public class StudentService {
    public void save(Student student) {
        String sql = "INSERT INTO student(id, name, age) VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.executeUpdate();
            System.out.println("Student saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {
        String sql = "SELECT * FROM student";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
