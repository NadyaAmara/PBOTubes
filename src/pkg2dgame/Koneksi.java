package pkg2dgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection koneksi;
    
    public static Connection getKoneksi()throws SQLException{
        try {
            String url = "jdbc:mysql://localhost:3306/2dgame";
            String user = "root";
            String password = "";
                
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, password);
            System.out.println("Berhasil Terhubung");
        }catch (SQLException e) {
            System.out.println("Koneksi Gagal" + e.getMessage());
        }
        return koneksi;
    }
}
