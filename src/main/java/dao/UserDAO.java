package dao;

import java.sql.*;
import model.User;
import util.DBConnection;

public class UserDAO {

    public User getUserByUsername(String username) {
        User user = null;
        System.out.println("Checking user for username: " + username);
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username=?";
            System.out.println(sql);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Các phương thức thêm, sửa, xóa...
}
