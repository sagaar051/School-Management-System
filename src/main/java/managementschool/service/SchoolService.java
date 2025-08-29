package managementschool.service;

import managementschool.entity.School;
import java.sql.*;

public class SchoolService {
    public void save(School school) {
        String sql = "INSERT INTO school(id, name, address) VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, school.getId());
            ps.setString(2, school.getName());
            ps.setString(3, school.getAddress());
            ps.executeUpdate();
            System.out.println("School saved successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllSchools() {
        String sql = "SELECT * FROM school";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(School school) {
        String sql = "UPDATE school SET name=?, address=? WHERE id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, school.getName());
            ps.setString(2, school.getAddress());
            ps.setInt(3, school.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("School updated successfully");
            } else {
                System.out.println("School not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM school WHERE id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("School deleted successfully");
            } else {
                System.out.println("School not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
