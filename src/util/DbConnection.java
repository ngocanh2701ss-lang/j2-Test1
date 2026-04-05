package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static Connection conn;

    public static Connection getConnection()
    {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa", dbPass = "123", //NHỚ SỬA PASS + TÊN CƠ SỞ DỮ LIỆU NHÉ
                        dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=demojava2;encrypt=true;trustServerCertificate=true;";
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công");
                
                /*note bài học slide 7: JDBC Nâng cao
                crud: c: creat, r:read, update, delete
                create **/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
        System.out.println(DbConnection.getConnection().toString());
    }
}
