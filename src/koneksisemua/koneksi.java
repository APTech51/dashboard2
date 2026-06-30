package koneksisemua;
import java.sql.*;

public class koneksi {
    
    // Bukan static, tiap form buat koneksi sendiri
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db_1", "root", ""
            );
            System.out.println("Koneksi berhasil!");
        } catch (Exception ex) {
            System.out.println("Koneksi gagal: " + ex.getMessage());
        }
        return conn;
    }
}