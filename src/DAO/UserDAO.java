package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;

public class UserDAO {
    public static boolean CheckLogin(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean ForgetPassword(String email) {
        String query = "Select * From users Where email = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement mt = connection.prepareStatement(query)){
            mt.setString(1, email);
            ResultSet rs = mt.executeQuery();

            return rs.next();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
