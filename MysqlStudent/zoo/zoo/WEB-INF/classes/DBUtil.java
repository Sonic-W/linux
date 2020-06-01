package DBUtil;

import java.sql.*;

public class DBUtil {
    private static String DRIVER="com.mysql.jdbc.Driver";
    private static String URL="jdbc:mysql://localhost:3306/student2?useSSL=false";
    private static String user="root";
    private static String key="root";
    public static Connection conn;
         static{
            try {
                Class.forName(DRIVER);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         public static Connection getConnection(){
         try {
            conn = DriverManager.getConnection(URL, user, key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return conn;
        }
}
