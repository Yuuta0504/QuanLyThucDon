package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Đăng ký MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Kết nối đến database
            conn = DriverManager.getConnection(Constant.url, Constant.username, Constant.password);
            System.out.println("Kết nối thành công đến database!");
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến database!");
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Đóng kết nối thành công!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi đóng kết nối!");
            e.printStackTrace();
        }
    }
}
