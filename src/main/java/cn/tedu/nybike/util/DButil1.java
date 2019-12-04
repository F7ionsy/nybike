package cn.tedu.nybike.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil1 {
	static String url ="jdbc:mysql://localhost:3307/nybike";
	static String username = "root";
	static String password = "123";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
}
