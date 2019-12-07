package cn.tedu.nybike.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil3 {
	static String url="jdbc:mysql://47.100.78.24:3306/nybikedb";
    static String user="root";
    static String password="123";

    static {
        try {
            // ×¢²áÇý¶¯
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
